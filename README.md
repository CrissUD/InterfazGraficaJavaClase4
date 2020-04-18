# Interfaz Gráfica en Java

Curso propuesto por el grupo de trabajo Semana de Ingenio y Diseño (**SID**) de la Universidad Distrital Francisco Jose de Caldas.

## Monitor

**Cristian Felipe Patiño Cáceres** - Estudiante de Ingeniería de Sistemas de la Universidad Distrital Francisco Jose de Caldas

# Clase 4

## Objetivos

- Reconocer la forma de Añadir modularidad a nuestro código en las clases **Template** separando la creación de objetos gráficos.
- Optimizar el código con el uso de un servicio que encapsula el funcionamiento de la construcción de objetos gráficos.
- Optimizar los recursos de nuestra aplicación con el uso de un servicio que administre los objetos que pueden ser utilizados en diferentes clases.

# Antes de comenzar

En nuestras anteriores clases hemos creado una clase **VistaPrincipalTemplate** y otra clase **LoginTemplate** cada una en su respectivo paquete como podemos ver a continuación:

<div align="center">
  <img  src="./resources/paquetes1.png">
  <p>Clases UI en sus respectivos paquetes</p>
</div>

Ahora y por motivos de modularidad vamos a crear un paquete llamado **client** y allí vamos a dejar nuestros paquetes de las clases UI que hemos creado. Nuestro archivo de ejecución App.java sigue estando ubicado en el paquete principal **app**.

<div align="center">
  <img  src="./resources/paquetes2.png">
  <p>Creación de paquete client que contiene nuestros paquetes creados previamente</p>
</div>

Recordando un poco nuestro recorrido, en nuestra primera clase habíamos creado nuestra clase **VistaPrincipalTemplate** que hasta el momento esta vacía:

<div align="center">
  <img  src="./resources/interfaz1.png">
  <p>Vista principal creada en primera clase.</p>
</div>

También creamos nuestra clase **LoginTemplate** y el resultado de nuestra anterior clase fue el siguiente:

<div align="center">
  <img  src="./resources/interfaz2.png">
  <p>Login de usuario resultado anterior clase.</p>
</div>

# Modularización de código

Ya hemos creado nuestro login de usuario que se ve muy bien, sin embargo si en algún momento queremos cambiar una configuración en alguno de los objetos gráficos creados va ser algo complicado de encontrar. Aunque nuestro código tiene algo de organización con la separación de la creación de cada uno de nuestros objetos gráficos, nuestro constructor tiene una gran cantidad de lineas de código.

<div align="center">
  <img  src="./resources/codigo1.png">
  <p>Separación de creación de objetos gráficos dentro del constructor.</p>
</div>


Una buena idea para organizar nuestro código seria la creación de métodos que nos ayuden con la separación de la creación de objetos gráficos de acuerdo a sus tipos. Por ejemplo podemos crear un método llamado **crearJPanels()** e insertar la creación de todos nuestros objetos tipo JPanel  allí.

```javascript
public void crearJPanels(){

    pIzquierda = new JPanel();
    pIzquierda.setSize(600, 500);
    pIzquierda.setLocation(0, 0);
    pIzquierda.setBackground(Color.white);
    pIzquierda.setLayout(null);
    this.add(pIzquierda);

    pDerecha = new JPanel();
    pDerecha.setSize(400, 500);
    pDerecha.setLocation(600, 0);
    pDerecha.setBackground(Color.white);
    pDerecha.setLayout(null);
    this.add(pDerecha);
}
```

Ahora por ejemplo podemos crear otro método llamado **crearJTextfields()** e insertar la creación de los objetos gráficos tipo JTextField.

```javascript
public void crearJTextFields(){

    tNombreUsuario = new JTextField("Nombre Usuario");
    tNombreUsuario.setSize(260, 40);
    tNombreUsuario.setLocation((pDerecha.getWidth() - tNombreUsuario.getWidth()) / 2, 130);
    tNombreUsuario.setForeground(colorAzul);
    tNombreUsuario.setBackground(Color.WHITE);
    tNombreUsuario.setCaretColor(colorGrisOscuro);
    tNombreUsuario.setBorder(border);
    tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
    pDerecha.add(tNombreUsuario);
}
```

otros métodos de creación necesarios para nuestra clase son:

```javascript
public void crearObjetosDecoradores(){
    ...
}
```
```javascript
public void crearJButtons(){
    ...
}
```
```javascript
public void crearJLabels(){
    ...
}
```
```javascript
public void crearJPasswordFields(){
    ...
}
```
```javascript
public void crearJComboBoxes(){
    ...
}
```
```javascript
public void crearJCheckBoxes(){
    ... // También se crea el objeto ButtonGroup aquí al ser un objeto auxiliar 
}
```

Hay que aclarar varias cosas aquí:

## ¿Por que es posible hacer esta modularización?

Como recordaremos, la declaración de nuestros objetos gráficos y objetos decoradores la realizamos de forma global al inicio de nuestra clase, haciendo de estos objetos gráficos atributos de nuestra clase. 

<div align="center">
  <img  src="./resources/atributos.png">
  <p>Atributos de la clase LoginTemplate.</p>
</div>

Esto permite que cualquier entorno interno (Método) dentro de nuestra clase pueda conocer cada uno de estos objetos gráficos. Por ejemplo si en un caso hipotético se realizara la declaración de los paneles dentro del método **crearJPanels()** estos objetos gráficos solo existirían dentro de ese método y cuando se quiera agregar el JTextField creado en el método **crearJTextFields()** al panel **pDerecha** saltara un error por que para ese método el panel pDerecha no existe.

<div align="center">
  <img  src="./resources/codigo2.png">
  <p>Error al crear los paneles dentro de un solo entorno.</p>
</div>

Es por esta razón que la declaración se hace de forma global y como atributos de nuestra clase. Aunque no todos nuestros objetos gráficos tienen que ser atributos, por ejemplo un **ButtonGroup** que solo afecta a los objetos **JCheckBox** se puede crear como variable en el método **crearJCheckBoxes()** y como probablemente este objeto no se necesite para nada más en el futuro se podría tratar como una variable dentro de este método. El programador debe elegir cual de los objetos gráficos y objetos Decoradores necesita declarar globalmente o como variable dentro de un entorno.  Sin embargo nunca se sabe cuando se podría necesitar alguno de estos en otro contexto así que como preferencia personal es preferible mantener todos los objetos gráficos y los objetos Decoradores como atributos.

## Ejecución de métodos de creación desde el constructor

Si ya hemos pasado todos nuestros objetos gráficos y objetos Decoradores a sus respectivos métodos nuestro constructor se vera ahora así: 

<div align="center">
  <img  src="./resources/codigo3.png">
  <p>Constructor después de hacer los métodos de creación.</p>
</div>

Se puede notar que lo único que esta dentro de nuestro constructor es la configuración de nuestra ventana. Si corremos nuestra aplicación notamos que no se vera nada. 

<div align="center">
  <img  src="./resources/interfaz3.png">
  <p>Login de usuario después de hacer los métodos de creación.</p>
</div>

Esto es por que tenemos que llamar desde el constructor nuestros métodos de creación. Por ejemplo al llamar estos métodos de creación : 

<div align="center">
  <img  src="./resources/codigo4.png">
  <p>Constructor después de hacer los métodos de creación.</p>
</div>

nuestra aplicación se vera así. 

<div align="center">
  <img  src="./resources/interfaz4.png">
  <p>Login de usuario con la llamada de algunos métodos de creación.</p>
</div>

Entonces es necesario llamar a todos estos métodos dentro del constructor.

## Organización en el eje Z y de métodos de creación

Tenemos que tener en cuenta la organización de los objetos con respecto al eje z como se discutió en la clase anterior. Eso quiere decir que hay que tener cuidado en el **orden en que vamos a llamar los métodos**. Por ejemplo:
* Si llamamos el método **crearJTextFields()** antes del método **crearJPanels()** ocurrirá un error por que no es posible añadir un objeto gráfico a un panel que aun no se ha creado.

<div align="center">
  <img  src="./resources/error1.png">
  <p>Error por que no se ha creado los JPanel previamente.</p>
</div>

* Si llamamos el método **crearObjetosDecoradores()** después de llamar cualquier otro método que crea objetos gráficos en los que se incorpora objetos decoradores ocurrirá un error.

<div align="center">
  <img  src="./resources/error2.png">
  <p>Error por que no se ha creado los objetos decoradores previamente.</p>
</div>

* Si llamamos el método **crearJLabels()** antes de llamar el método de **crearJButtons()** el fondo del login tapara los botones en el panel **pIzquierda**.

<div align="center">
  <img  src="./resources/interfaz5.png">
  <p>Los botones del panel pIzquierda no se ven por que están tapados por el fondo.</p>
</div>

Entonces es necesario que el programador tenga en cuenta la organización en la llamada de los métodos de creación. Una organización apropiada para nuestro caso puede ser:

<div align="center">
  <img  src="./resources/codigo5.png">
  <p>Organización correcta en la llamada de los métodos de creación.</p>
</div>

## Ventajas de este enfoque

Nuestro código esta más organizado, cuando queramos cambiar la configuración de algún botón ya no tardaremos en encontrarlo dentro del constructor, ahora podremos ir a nuestro método encargado de la creación de botones y cambiar lo que consideremos necesario. 

Ademas para poder concentrarnos aun mejor en una parte de nuestro código, el editor de texto nos da la posibilidad de minimizar el código por métodos y así concentrarnos en una sola parte de este.

<div align="center">
  <img  src="./resources/codigo6.png">
  <p>Minimización de código por métodos.</p>
</div>


# Optimización de código

Ya aprendimos la forma de como crear nuestros objetos gráficos para mostrarlos en pantalla y como crear objetos decoradores para incorporarlos en ellos. Sin embargo son muchas las configuraciones que hay que aprender y es mucho el código que se extiende en nuestras clases para la creación de estos objetos gráficos. Si nuestra interfaz Gráfica de usuario tiene 20 botones por ejemplo debemos realizar el proceso de creación 20 veces y no solo gasta tiempo sino que requiere la memorización de muchas configuraciones y nuestro codigo se hará más y más largo.

Una alternativa a esto es la creación de una clase que se encargue de proporcionarnos un servicio, este servicio sera el de la construcción de los objetos gráficos de forma genérica de tal forma que para crear uno de estos objetos solo tengamos que llamar al servicio y este nos lo retorne. Vamos a explicar de que se trata.

**Nota**: *Antes de continuar vamos a ver que se tratara con un tema relacionado a los servicios, esta clase no tiene como finalidad explicar que son los servicios asi que solo se dará una breve explicación de ellos a medida que se avanza, sin embargo en clases posteriores nos enfocaremos en su concepto y finalidad.*

Dentro de nuestro proyecto en el paquete raíz **app** ahora crearemos un nuevo paquete al cual llamaremos **services** y dentro crearemos una clase llamada **ObjGraficosService**.

<div align="center">
  <img  src="./resources/paquetes3.png">
  <p>Creación de paquete services y servicio para la creación de objetos gráficos.</p>
</div>

Cabe resaltar que los servicios que creemos en nuestro proyecto tendrán el nombre de la clase (arbitrario) seguido de la palabra **Service**.

Nuestra clase **ObjGraficosService** se encargará de la creación de los objetos gráficos a traves de métodos que podremos usar desde cualquier clase **Template** que tengamos en nuestro proyecto. Para garantizar lo anterior dicho debemos crear un mecanismo para que cualquier clase desde cualquier parte pueda llamar al objeto y pueda usar sus métodos pero a su vez **este objeto solo se cree una vez para todas las clases.**

## Singleton 

Es importante que este servicio se cree una vez en memoria y solo una vez por que va a ser un objeto usado en todas las clases **template** que creemos y si nuestro proyecto tiene 30 clases y si cada clase crea un objeto de este servicio estamos creando 29 objetos de más innecesarios que consumirán recursos. 

Lo primero que haremos es crear su constructor pero su **tipo de acceso será privado**:

```javascript
private ObjGraficosService(){
        
}
```
Esto garantiza que no se pueda ejemplificar el objeto desde ninguna otra clase (es decir no se puede hacer  **.. = new ObjGraficosService()**).

Dentro de la misma clase **ObjGraficosService** vamos a crear un objeto **static** de tipo de la misma clase:
```javascript
static private ObjGraficosService servicio;
```

Ahora realizaremos un método **static** para crear el objeto de este servicio y retornarlo a quien lo necesite.

```javascript
public static ObjGraficosService getService(){
    if(servicio == null){
        servicio = new ObjGraficosService();
    }
    return servicio;
}
```
Se pueden notar varias cosas del método anterior:
* La palabra clave **static** asegura que el método dentro de este servicio pueda ser llamado desde cualquier otra clase sin necesidad de ejemplificar el objeto anteriormente. 
* En el atributo de la clase se pone el **static** también por que las variables que se trabajen dentro de un método **static** deben serlo también.
* El método retorna un objeto de la propia clase.
* El **if** asegura la ejemplificación única del objeto del servicio, si este es nulo lo ejemplifica, cosa que ocurrirá la primera vez que se llame al método. Pero la segunda vez que se llame, como este objeto ya fue ejemplificado previamente ya no entrara al if y lo retornara simplemente.
* Este método que acabamos de realizar es conocido como **Patron Singleton**.

Ahora en nuestra Clase **LoginTemplate** podemos obtener su objeto llamando a este método de la siguiente manera:
* Primero se importa el servicio
```javascript
import app.services.ObjGraficosService;
```
* Se declara el objeto:
```javascript
private ObjGraficosService sObjGraficos;
```
La declaración de los objetos de los servicios inician con una s en minúscula seguido de la variable (objeto) arbitraria.

* Se obtiene su ejemplificacíon dentro del constructor (Esta sera la primera linea de código en el constructor).
```javascript
sObjGraficos = ObjGraficosService.getService();
```

Como esta es la primera clase que llama a este método el objeto del servicio se ejemplificará, pero mas adelante cuando otra clase **template** realice el mismo proceso obtendrá el objeto que ya se había ejemplificado previamente.

Ahora veremos un acercamiento de como serán los métodos de que encapsulan la creación genérica de los objetos gráficos dentro del servicio:

## JPanel 

Dentro de nuestro servicio podemos empezar con la construcción de paneles para esto declaramos un objeto gráfico tipo JPanel y lo configuramos dentro de un método al cual llamaremos **construirJPanel**, este recibirá por parámetros las cosas necesarias para su correcta creación.

```javascript
private JPanel panel;
```
```javascript
public JPanel construirJPanel(int x, int y, int ancho, int alto, Color colorFondo, Border borde){
    panel = new JPanel(); 
    panel.setSize(ancho, alto);
    panel.setLocation(x, y);
    panel.setLayout(null);
    panel.setBackground(colorFondo);
    panel.setBorder(borde);
    return panel;
}
```
Podemos observar que este método retorna un objeto tipo JPanel y recibe por parámetros: 
* **Posición en x**: recibe un entero (int).
* **Posición en y**: recibe un entero (int).
* **Ancho**: recibe un entero (int).
* **Alto**: recibe un entero (int).
* **Color de Fondo**: recibe un objeto decorador tipo Color.
* **Borde**: recibe un objeto decorador tipo Border.

Adentro se encarga de la **ejemplificación y configuración del objeto gráfico para después retornarlo** por lo que realiza 2 de las 4 etapas de la creación de un objeto gráfico, estas dos etapas las podemos generalizar en un termino que es la construcción del objeto, esta es la razón de su nombre.

Ahora desde nuestra clase **LoginTemplate** podemos llamar a este método buscando un panel dentro del método encargado de la creación de paneles y poner:

```javascript
pIzquierda = sObjGraficos.construirJPanel(0, 0, 600, 500, Color.WHITE, null);
this.add(pIzquierda);
```

Note varias cosas importantes:
* La creación de un JPanel se redujo de 6 lineas de código a solo 2.
<div align="center">
  <img  src="./resources/codigo7.png">
  <p>Comparación de creación de un JPanel de forma habitual o con el servicio.</p>
</div>

* Nuestros nombres en los parámetros son muy intuitivos esto quiere decir que ya no tenemos que recordar el nombre exacto de cada método de configuración en el futuro si no que ya sabemos que debemos enviar.
<div align="center">
  <img  src="./resources/codigo8.png">
  <p>Parámetros intuitivos en la creación de nuestros objetos gráficos.</p>
</div>

* Si un objeto gráfico no contiene alguna propiedad que se pide en el método como es el ejemplo de un borde para nuestro panel simplemente se envía el argumento como **null**. 

<div align="center">
  <img  src="./resources/codigo9.png">
  <p>Argumento de borde enviado como null ya que no se requiere en el panel.</p>
</div>

* Si considera que el código ocupa mucho espacio de forma horizontal puede acomodarlo a su preferencia:

<div align="center">
  <img  src="./resources/codigo10.png">
  <p>Otras formas de formatos del código.</p>
</div>


## JButton

Vamos a ver como se realizaría el método para la creación genérica de un botón. Y mostramos este en especifico por que es el método de construcción que necesite más parámetros para construir

```javascript
public JButton construirJButton(
    String texto, int x, int y, int ancho, int alto, Cursor cursor, 
    ImageIcon imagen, Font fuente, Color colorFondo, Color colorFuente, 
    Border borde, String direccion, boolean esSolido){
        
    button= new JButton(texto);
    button.setSize(ancho, alto);
    button.setLocation(x, y);
    button.setFocusable(false);
    button.setCursor(cursor);
    button.setFont(fuente);
    button.setBackground(colorFondo);
    button.setForeground(colorFuente);
    button.setIcon(imagen);
    button.setBorder(borde);
    button.setContentAreaFilled(esSolido);
    switch(direccion){
        case "l":
            button.setHorizontalAlignment(SwingConstants.LEFT);
            break;
        case "r":
            button.setHorizontalAlignment(SwingConstants.RIGHT);
            break;    
        default:
            break;
    }
    return button;
}
```

Podemos observar que el método recibe por parámetros lo siguiente: 

* **texto del botón:** recibe un String..
* **posición x:** recibe un entero (int).
* **posición y:** recibe un entero (int).
* **ancho:** recibe un entero (int).
* **alto:** recibe un entero (int).
* **cursor:** recibe un objeto decorador tipo Cursor. 
* **imagen:** recibe un objeto decorador tipo ImageIcon. 
* **fuente:** recibe un objeto decorador tipo Font.
* **color de Fondo**:  recibe un objeto decorador tipo Color.
* **color de Fuente:**  recibe un objeto decorador tipo Color.
* **borde:** recibe un objeto decorador tipo Border.
* **dirección:** recibe un String que representa la posición horizontal de lo que contenga el botón. Esta puede ser:
    * "l" (left): si se desea dejar el contenido en la parte izquierda.
    * "c" (center): si se desea dejar el contenido en el centro.
    * "r" (right): si se desea dejar el contenido en la parte derecha.
* **¿es Solido?:** recibe un booleano, si se manda en True dejara las propiedades de contenido de Java, si se pasa como True le quitara esas propiedades dejándolo transparente.

Ahora desde nuestra clase **LoginTemplate** podemos llamar a este método para la construcción de los botones, a continuación se muestran 2 botones diferentes para ver las particularidades:
```javascript
bEntrar = sObjGraficos.construirJButton(
    "Entrar", (pDerecha.getWidth() - 230) / 2, 330, 
    250, 45, cMano, null, null, colorAzul, 
    Color.WHITE, null, "c", true
);
pDerecha.add(bEntrar);

iDimAux = new ImageIcon(
    iCerrar.getImage().getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
);

bCerrar = sObjGraficos.construirJButton(
    null, 350, 10, 45, 30, 
    cMano, iDimAux, null, 
    null, null, null, "c", false
);
pDerecha.add(bCerrar);
```

Podemos observar lo siguiente en la creación de los dos anteriores botones:
* **Primer botón:**
    * Este botón contiene texto asi que se enviá.
    * Va posicionado en la mitad del panel por lo que se envía el calculo pero ahora enviando el ancho del botón como numero directamente. 
    * Tiene incorporado un cursor y se envía como argumento.
    * Tiene color de fondo y color de fuente por lo que se envía como argumento.
    * Su contenido esta centrado por lo que se envía una "c".
    * Como este botón tiene color de fondo entonces es un botón solido y se envía True.
* **Segundo botón:**
    * Este botón no texto asi que se enviá null como argumento.
    * Este botón contiene una imagen, pero esta debe ser previamente redimensionada para poder ser enviada. 
    * Tiene incorporado un cursor y se envía como argumento.
    * No contiene ningún color asi que se envía como argumentos null.
    * Su contenido esta centrado por lo que se envía una "c".
    * Como este botón no tiene color de fondo entonces es un botón transparente y se envía un False para conseguir esto.