# Interfaz Gráfica en Java

Curso propuesto por el grupo de trabajo Semana de Ingenio y Diseño (**SID**) de la Universidad Distrital Francisco Jose de Caldas.

## Monitor

**Cristian Felipe Patiño Cáceres** - Estudiante de Ingeniería de Sistemas de la Universidad Distrital Francisco Jose de Caldas

# Clase 4

## Objetivos

- Reconocer la forma de añadir modularidad al código en las clases **Template** separando la creación de objetos gráficos.
- Optimizar el código con el uso de un servicio que encapsule el funcionamiento de la construcción de objetos gráficos.
- Optimizar los recursos de la aplicación con el uso de un servicio que administre los objetos que pueden ser utilizados en diferentes clases.

# Antes de comenzar

En las anteriores sesiones se han creado las clases **VistaPrincipalTemplate** y **LoginTemplate** cada una en su respectivo paquete como se puede ver a continuación:

<div align="center">
  <img  src="https://i.imgur.com/10m0bZa.png">
  <p>Clases UI en sus respectivos paquetes</p>
</div>

Ahora por motivos de modularidad se crea un paquete llamado **client** y allí se dejan los paquetes de las clases UI que se han creado. El archivo de ejecución App.java sigue estando ubicado en el paquete principal **app**.

<div align="center">
  <img  src="https://i.imgur.com/1ToVlXl.png">
  <p>Creación de paquete client que contiene los paquetes creados previamente</p>
</div>

Recordando un poco el recorrido del curso, en la primera sesión se había creado la clase **VistaPrincipalTemplate** que hasta el momento esta vacía:

<div align="center">
  <img  src="https://i.imgur.com/6r7acbV.png">
  <p>Vista principal creada en primera sesión.</p>
</div>

También se creo la clase **LoginTemplate** y el resultado de la anterior sesión fue el siguiente:

<div align="center">
  <img  src="https://i.imgur.com/FD2wbHw.png">
  <p>Login de usuario resultado anterior sesión.</p>
</div>

# Modularización y optimización

En esta lección se van a tratar 3 temas principales que serán de vital ayuda para que el código creado al construir interfaces gráficas de usuario sea ordenado, mantenible, entendible y sencillo. Los temas principales son:

* **Modularización de código**
* **Optimización de código**
* **Optimización de recursos**

# Modularización de código

Ya se ha creado el login de usuario usando objetos gráficos y objetos decoradores los cuales hacen que la interfaz de usuario se vea muy bien, sin embargo, si en algún momento se quiere cambiar alguna configuración en uno de los objetos gráficos creados, realmente va ser algo complicado encontrar dicho objeto dentro del constructor. Aunque el código tiene algo de organización con la separación de la creación de cada uno de los objetos gráficos, el constructor tiene una gran cantidad de lineas de código.

<div align="center">
  <img  src="https://i.imgur.com/a99Gvso.png">
  <p>Separación de creación de objetos gráficos dentro del constructor.</p>
</div>

Una buena idea para organizar el código es el uso de métodos que nos ayuden a separar la creación de objetos gráficos de acuerdo a varios criterios, algunos de ellos podrían ser por sus tipos, por contenido, por contexto etc. Por ejemplo en el login se puede realizar la creación de métodos que separe de acuerdo al tipo de objetos y con base a esto crear un método llamado **crearJPanels()** y se inserta la creación de todos los objetos tipo JPanel  allí.

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

Ahora se crea otro método llamado **crearJTextfields()** y se inserta la creación de los objetos gráficos tipo JTextField.

```javascript
public void crearJTextFields(){
  tNombreUsuario = new JTextField("Nombre Usuario");
  tNombreUsuario.setSize(260, 40);
  tNombreUsuario.setLocation((pDerecha.getWidth() - tNombreUsuario.getWidth()) / 2, 130);
  tNombreUsuario.setForeground(colorAzul);
  tNombreUsuario.setBackground(Color.WHITE);
  tNombreUsuario.setCaretColor(colorGrisOscuro);
  tNombreUsuario.setBorder(bInferiorAzul);
  tNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
  pDerecha.add(tNombreUsuario);
}
```
Otro método podría ser el de **crearObjetosDecoradores** donde se inserta la creación de todos los objetos de este tipo:
```javascript
public void crearObjetosDecoradores(){
  colorAzul = new Color(60, 78, 120);
  colorGrisOscuro = new Color(80, 80, 80);
  fontTPrincipal = new Font("Rockwell Extra Bold", Font.PLAIN, 20);
  fontTitulo = new Font("Calibri (Cuerpo)", Font.BOLD, 17);
  fontSubtitulo = new Font("Forte", Font.PLAIN, 13);
  fontMediana = new Font("LuzSans-Book", Font.PLAIN, 15);
  cMano = new Cursor(Cursor.HAND_CURSOR);
  bInferiorAzul = BorderFactory.createMatteBorder(0, 0, 2, 0, colorAzul);
  iFondo = new ImageIcon("Clase4/resources/images/fondo.png");
  iLogo = new ImageIcon("Clase4/resources/images/logo.png");
  iUsuario2 = new ImageIcon("Clase4/resources/images/usuario2.png");
  iClave2 = new ImageIcon("Clase4/resources/images/clave2.png");
  iPunto1 = new ImageIcon("Clase4/resources/images/punto1.png");
  iFacebook1 = new ImageIcon("Clase4/resources/images/facebook1.png");
  iTwitter1 = new ImageIcon("Clase4/resources/images/twitter1.png");
  iYoutube1 = new ImageIcon("Clase4/resources/images/youtube1.png");
  iSvg1 = new ImageIcon("Clase4/resources/images/imagen1.png");
  iCerrar = new ImageIcon("Clase4/resources/images/cerrar.png");
}
```

otros métodos de creación necesarios para la clase son:
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

Una vez realizada la modularización, vale la pena aclarar varias aspectos:

## Excepción

Existe una excepción para el objeto decorador **iDimAux** encargado de redimensionar las imágenes, este estará presente en los diferentes métodos de construcción respectiva al objeto gráfico al que se va a incorporar, ya que es un objeto auxiliar y es necesario dejarlo justo encima del objeto gráfico al que se incorpora, porque que esta variable estará cambiando constantemente con cada redimension nueva requerida.

<div align="center">
  <img  src="https://i.imgur.com/X1LFbYS.png">
  <p>Excepción con el objeto auxiliar que estará presente en varios métodos de creación.</p>
</div>

## ¿Por que es posible hacer esta modularización?

Como se vio en las anteriores lecciones, la declaración de los objetos gráficos y objetos decoradores se realiza de forma global en la clase ya que se ubica al inicio de la misma, haciendo de estos objetos atributos de la clase. 

<div align="center">
  <img  src="https://i.imgur.com/3lTsBWQ.png">
  <p>Atributos de la clase LoginTemplate.</p>
</div>

Esto permite que cualquier entorno interno (Método) dentro de la clase pueda conocer cada uno de estos objetos gráficos. Por ejemplo si en un caso hipotético se realizara la declaración de los paneles dentro del método **crearJPanels()** estos objetos gráficos solo existirían dentro de ese método y cuando se quiera agregar el JTextField creado en el método **crearJTextFields()** al panel **pDerecha** saltará un error porque para ese método el panel pDerecha no existe.

<div align="center">
  <img  src="https://i.imgur.com/yHKYA9r.png">
  <p>Error al declarar los paneles dentro de un solo entorno.</p>
</div>

Es por esta razón que la declaración se hace de forma global y como atributos de la clase **separando la declaración de la ejemplificación**. La declaración ira siempre al empezar las clases, la ejemplificación ira dentro de cada uno de los métodos.

Aunque no todos los objetos gráficos o decoradores tienen que ser atributos, por ejemplo un **ButtonGroup** que solo afecta a los objetos **JCheckBox** se puede crear como variable en el método **crearJCheckBoxes()** y como probablemente este objeto no se necesite para nada más en el futuro se podría tratar como una variable dentro de este método. El programador debe elegir cual de los objetos gráficos y objetos Decoradores necesita declarar globalmente o como variable dentro de un entorno.  Sin embargo nunca se sabe cuando se podría necesitar alguno de estos en otro contexto (otras clases) así que es preferible mantener todos los objetos gráficos y los objetos Decoradores como atributos de la clase.

## Ejecución de métodos de creación desde el constructor

Una vez pasados todos los objetos gráficos y objetos Decoradores a sus respectivos métodos, el constructor se verá así: 

<div align="center">
  <img  src="https://i.imgur.com/GBuYAhg.png">
  <p>Constructor después de hacer los métodos de creación.</p>
</div>

Se puede notar que lo único que esta dentro del constructor es la configuración de la ventana. Si se ejecuta la aplicación se observa que no se verá nada. 

<div align="center">
  <img  src="https://i.imgur.com/pVOvhEz.png">
  <p>Login de usuario después de hacer los métodos de creación.</p>
</div>

Esto es por que se debe que llamar desde el constructor a los métodos de creación. Por ejemplo al llamar estos 4 métodos de creación : 

<div align="center">
  <img  src="https://i.imgur.com/IaLF5AW.png">
  <p>Constructor después de hacer los métodos de creación.</p>
</div>

La aplicación se vera así. 

<div align="center">
  <img  src="https://i.imgur.com/sEB2BD9.png">
  <p>Login de usuario con la llamada de algunos métodos de creación.</p>
</div>

Por lo que es necesario llamar a todos estos métodos de creación dentro del constructor.

## Organización en el eje Z y de métodos de creación

Se debe tener en cuenta la organización de los objetos con respecto al eje z como se discutió en la lección anterior. Eso quiere decir que hay que tener cuidado en el **orden en que se van a llamar los métodos**. Por ejemplo:
* Si llamamos el método **crearJTextFields()** antes del método **crearJPanels()** ocurrirá un error por que no es posible añadir un objeto gráfico a un panel que aun no se ha creado.

<div align="center">
  <img  src="https://i.imgur.com/0atJP3f.png">
  <p>Error por que no se ha creado los JPanel previamente.</p>
</div>

* Si llamamos el método **crearObjetosDecoradores()** después de llamar cualquier otro método que crea objetos gráficos en los que se incorporan objetos decoradores ocurrirá un error.

<div align="center">
  <img  src="https://i.imgur.com/u3WGzsW.png">
  <p>Error por que no se ha creado los objetos decoradores previamente.</p>
</div>

* Si llamamos el método **crearJLabels()** antes de llamar el método de **crearJButtons()** el fondo del login tapara los botones en el panel **pIzquierda**.

<div align="center">
  <img  src="https://i.imgur.com/gPdBazV.png">
  <p>Los botones del panel pIzquierda no se ven por que están tapados por el fondo.</p>
</div>

Entonces es necesario que el programador tenga en cuenta la organización en la llamada de los métodos de creación. Una organización apropiada para este caso puede ser:

<div align="center">
  <img  src="https://i.imgur.com/gczbxCe.png">
  <p>Organización correcta en la llamada de los métodos de creación.</p>
</div>

## Ventajas de este enfoque

El código esta más organizado, cuando se quiera cambiar la configuración de algún botón ya no será una tarea tediosa el tener que encontrarlo dentro del constructor, ahora solo hay que enfocarse en el método encargado de la creación de botones y cambiar lo que sea necesario. 

Ademas para poder concentrarse aun mejor en una parte del código, el editor de texto da la posibilidad de minimizar el código por métodos y así enfocarse en una sola parte de este.

<div align="center">
  <img  src="https://i.imgur.com/MHlgwcn.png">
  <p>Minimización de código por métodos.</p>
</div>

# Optimización de código

Ya se vio la forma de como crear los objetos gráficos para ser mostrados en pantalla y como crear objetos decoradores para incorporarlos en los primeros. Sin embargo, son muchas las configuraciones que hay que aprender y es mucho el código que se extiende en las clases para la creación de estos objetos gráficos. Si la interfaz Gráfica de usuario tiene 20 botones por ejemplo se debe realizar el proceso de creación 20 veces y no solo gasta tiempo sino que requiere la memorización de muchas configuraciones y el código se hará más y más largo.

Una alternativa a esto es la creación de una clase que se encargue de proporcionar un servicio, este servicio será el de la construcción de los objetos gráficos de forma genérica de tal manera que para crear uno objeto gráfico solo se tenga que llamar al servicio, pasar los parámetros correspondientes y este retorne el objeto construido. A continuaron se va a explicar como realizar este servicio.

**Nota**: *A continuación se tratara con un tema relacionado a los servicios, esta sesión no tiene como finalidad explicar que son los servicios asi que solo se dará una breve explicación de ellos a medida que se avanza, sin embargo en clases posteriores se va a explicar su concepto y finalidad. Estos servicios tampoco están relacionados al concepto de servicios web.* 

Dentro del proyecto en el paquete **app** se crea un nuevo paquete llamado **services** y dentro se crea una clase llamada **ObjGraficosService**.

<div align="center">
  <img  src="https://i.imgur.com/zEI9roS.png">
  <p>Creación de paquete services y servicio para la construcción de objetos gráficos.</p>
</div>

Cabe resaltar que los servicios que se crean en el proyecto tendrán el nombre de la clase (arbitrario) seguido de la palabra **Service**.

La clase **ObjGraficosService** se encargará de la **construcción** de los objetos gráficos a traves de métodos que se podrán usar desde cualquier clase **Template** dentro del proyecto. Para garantizar lo anterior dicho, debemos crear un mecanismo para que cualquier clase dentro de la aplicación pueda llamar al objeto del servicio y pueda usar sus métodos pero a su vez **este objeto solo se cree una vez para todas las clases.**

### **Paréntesis**
 
Antes se hablo de las 4 etapas de la creación de un objeto gráfico:
* **Declarar**
* **Ejemplificar**
* **Configurar**
* **Adicionar**

Note que se esta hablando del termino que es la **construcción** de un objeto, este termino hace referencia a la generalización de 2 de las 4 etapas que son la de **ejemplificar** **configurar** quedando:

* **Declarar**
* **Construir** **(Ejemplificar, Configurar)**
* **Adicionar**

Por lo que el servicio se va a encargar de realizar justamente la etapa de construcción de los objetos.


## Singleton 

Es importante que este servicio se cree una sola vez en memoria. Esto por que va a ser un objeto usado en todas las clases **template** que se creen y si el proyecto tiene 30 clases por ejemplo y si cada una de estas crea un objeto de este servicio se están creando 29 objetos de más innecesarios que consumirán recursos. 

Lo primero que se hará es crear su constructor pero su **tipo de acceso será privado**:

```javascript
private ObjGraficosService(){ }
```
Esto garantiza que no se pueda ejemplificar el objeto desde ninguna otra clase (es decir no se puede hacer  **.. = new ObjGraficosService()**).

Dentro de la misma clase **ObjGraficosService** se  declarara un objeto **static** del tipo de la misma clase del servicio:
```javascript
static private ObjGraficosService servicio;
```

Ahora se crea un método **static** que se encarga de la ejemplificación del objeto de este servicio y retornarlo a quien lo necesite.

```javascript
public static ObjGraficosService getService(){
    if(servicio == null) servicio = new ObjGraficosService();
    return servicio;
}
```
Se pueden notar varias cosas del método anterior:
* La palabra clave **static** asegura que el método dentro de este servicio pueda ser llamado desde cualquier otra clase sin necesidad de ejemplificar el objeto anteriormente. 
* En el atributo de la clase se pone el **static** también por que las variables que se trabajen dentro de un método **static** deben serlo también.
* El método retorna un objeto de la propia clase. Esto quiere decir que es la misma clase la única encargada de su propia ejemplificación.
* la condición **if** asegura la ejemplificación única del objeto del servicio, si este es nulo lo ejemplifica y lo retorna, cosa que ocurrirá la primera vez que se llame al método. Pero en las posteriores llamadas al método, como el objeto ya fue ejemplificado previamente ya no entrara al if y lo retornara simplemente.
* Este método que acabamos de realizar es conocido como **Patron Singleton** y hace parte de los patrones creacionales de diseño.

Ahora en la clase **LoginTemplate** podemos obtener el objeto del servicio llamando a este método de la siguiente manera:
* Primero se importa el servicio
```javascript
import app.services.ObjGraficosService;
```
* Se declara el objeto:
```javascript
// Al inicio de la clase
private ObjGraficosService sObjGraficos;
```
La declaración de los objetos de los servicios inician con una s en minúscula seguido de la variable (objeto) arbitraria.

* Se obtiene su ejemplificacíon dentro del constructor (Esta sera la primera linea de código en el constructor).
```javascript
// Dentro del constructor
sObjGraficos = ObjGraficosService.getService();
```

Como esta es la primera clase que llama a este método el objeto del servicio se ejemplificará, pero mas adelante cuando otra clase **template** realice el mismo proceso obtendrá el objeto que ya se había ejemplificado previamente.

Ahora se verá un acercamiento de como serán los métodos de que encapsulan la construcción genérica de los objetos gráficos dentro del servicio:

## JPanel 

Dentro del servicio se puede encapsular la construcción de paneles, para esto declaramos un objeto gráfico tipo JPanel y lo configuramos dentro de un método al cual llamaremos **construirJPanel**, este recibirá por parámetros las características necesarias para su correcta construcción.

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
* **Posición en x**: Recibe un entero (int).
* **Posición en y**: Recibe un entero (int).
* **Ancho**: Recibe un entero (int).
* **Alto**: Recibe un entero (int).
* **Color de Fondo**: Recibe un objeto decorador tipo Color.
* **Borde**: Recibe un objeto decorador tipo Border.

Adentro se encarga de la **ejemplificación y configuración del objeto gráfico para después retornarlo** por lo que realiza 2 de las 4 etapas de la creación de un objeto gráfico, recordar que estas dos etapas se generalizan en un termino que es la **construcción del objeto**, esta es la razón del nombre del método.

También se puede notar que hay configuraciones por defecto como la anulación del Layout Manager para ser posicionado por el desarrollador.

Ahora desde la clase **LoginTemplate** es posible llamar a este método buscando un panel dentro del método encargado de la creación de paneles:

```javascript
pIzquierda = sObjGraficos.construirJPanel(0, 0, 600, 500, Color.WHITE, null);
this.add(pIzquierda);
```

**Note varias cosas importantes:**
* La creación de un JPanel se redujo de 6 lineas de código a solo 2.
<div align="center">
  <img  src="https://i.imgur.com/f11pBhw.png">
  <p>Comparación de creación de un JPanel de forma habitual o con el servicio.</p>
</div>

* Los nombres en los parámetros son muy intuitivos esto quiere decir que ya no se tiene que recordar el nombre exacto de cada método de configuración en el futuro si no que el método explica que se debe enviar.
<div align="center">
  <img  src="https://i.imgur.com/PLHkCLV.png">
  <p>Parámetros intuitivos en la creación de los objetos gráficos.</p>
</div>

* Si un objeto gráfico no contiene alguna propiedad que se pide en el método como es el ejemplo de un borde para el panel simplemente se envía el argumento como **null**. 

<div align="center">
  <img  src="https://i.imgur.com/Ey6fCmG.png">
  <p>Argumento de borde enviado como null ya que no se requiere en el panel.</p>
</div>

* Si el desarrollador considera que el código ocupa mucho espacio de forma horizontal puede acomodarlo a su preferencia:

<div align="center">
  <img  src="https://i.imgur.com/mKAQRmm.png">
  <p>Otras formas de identar del código.</p>
</div>

Se realiza el mismo proceso con el otros paneles dentro del login, en este caso el panel  **pDerecha**.

## JButton

Se va a mostrar como se realizaría el método para la construcción genérica de un botón. Y se explica este método en especifico por que es el método de construcción que necesita más parámetros para construir:

* **Declaración:**
```javascript
private JButton button;
```
* **Método de construcción:**
```javascript
public JButton construirJButton(
  String texto, int x, int y, int ancho, int alto, Cursor cursor, ImageIcon imagen, Font fuente,
  Color colorFondo, Color colorFuente, Border borde, String direccion, boolean esSolido
) {
  button = new JButton(texto);
  button.setLocation(x, y);
  button.setSize(ancho, alto);
  button.setFocusable(false);
  button.setCursor(cursor);
  button.setFont(fuente);
  button.setBackground(colorFondo);
  button.setForeground(colorFuente);
  button.setIcon(imagen);
  button.setBorder(borde);
  button.setContentAreaFilled(esSolido);
  switch (direccion) {
    case "l":
      button.setHorizontalAlignment(SwingConstants.LEFT);
      break;
    case "r":
      button.setHorizontalAlignment(SwingConstants.RIGHT);
      button.setHorizontalTextPosition(SwingConstants.LEFT);
      break;
    case "t":
      button.setVerticalTextPosition(SwingConstants.TOP);
      button.setHorizontalTextPosition(SwingConstants.CENTER);
      break;
    case "b":
      button.setVerticalTextPosition(SwingConstants.BOTTOM);
      button.setHorizontalTextPosition(SwingConstants.CENTER);
      break;
    default:
      break;
  }
  return button;
}
```

Podemos observar que el método recibe por parámetros lo siguiente: 

* **texto del botón:** Recibe un String.
* **posición x:** Recibe un entero (int).
* **posición y:** Recibe un entero (int).
* **ancho:** Recibe un entero (int).
* **alto:** Recibe un entero (int).
* **cursor:** Recibe un objeto decorador tipo Cursor. 
* **imagen:** Recibe un objeto decorador tipo ImageIcon. 
* **fuente:** Recibe un objeto decorador tipo Font.
* **color de Fondo**:  Recibe un objeto decorador tipo Color.
* **color de Fuente:**  Recibe un objeto decorador tipo Color.
* **borde:** Recibe un objeto decorador tipo Border.
* **dirección:** Recibe un String que representa la posición horizontal de lo que contenga el botón. Esta puede ser:
   * 'c' (CENTER): Contenido centrado (por defecto).
   * 't' (TOP): Contenido centrado con texto arriba de una imágen.
   * 'l' (LEFT): Contenido en la izquierda [Si tiene imágen y texto la imágen se posiciona primero].
   * 'r' (RIGHT): Contenido en la derecha [Si tiene imágen y texto el texto se posiciona primero].
   * 'b' (BOTTOM): Contenido centrado con texto abajo de una imágen.
* **¿es Solido?:** Recibe un booleano, y pregunta si se quiere crear un botón solido o transparente. Si se manda en True dejara las propiedades de contenido de Java, si se pasa como False le quitara esas propiedades dejándolo transparente.

Ahora desde la clase **LoginTemplate** se puede llamar a este método para la construcción de los botones, para lo que se entra al método encargado de la creación de los botones. A continuación se muestran 2 botones diferentes para ver algunas particularidades:
```javascript
bEntrar = sObjGraficos.construirJButton(
  "Entrar", 
  (pDerecha.getWidth() - 250) / 2, 330, 250, 45, 
  cMano, 
  null, null, 
  colorAzul, 
  Color.WHITE, 
  null, 
  "c", 
  true
);
pDerecha.add(bEntrar);

iDimAux = new ImageIcon(
    iCerrar.getImage()
      .getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING)
);

bCerrar = sObjGraficos.construirJButton(
  null, 
  350, 10, 45, 30, 
  cMano, 
  iDimAux, 
  null, null, null, null, 
  "c", 
  false
);
pDerecha.add(bCerrar);
```

Se puede observar lo siguiente en la creación de los dos anteriores botones:
* **Primer botón:**
    * Este botón contiene texto asi que se enviá en forma de comillas " ".
    * Va posicionado en la mitad del panel por lo que se envía el calculo, solo que ahora enviando el ancho del botón como numero directamente. 
    * Tiene incorporado un cursor y se envía como argumento.
    * Tiene color de fondo y color de fuente por lo que se envía como argumento.
    * No contiene ni un borde ni una imagen ni una fuente asi que se envía como argumentos null.
    * Su contenido esta centrado por lo que se envía una "c" como argumento.
    * Como este botón tiene color de fondo entonces es un botón solido y se envía True.
* **Segundo botón:**
    * Este botón no tiene texto asi que se enviá null como argumento.
    * Este botón contiene una imagen, pero esta debe ser previamente redimensionada para que al enviarse quede como se quiere. 
    * Tiene incorporado un cursor y se envía como argumento.
    * No contiene ningún color asi que se envía como argumentos null.
    * No contiene ni un borde ni una fuente asi que se envía como argumentos null.
    * Su contenido esta centrado por lo que se envía una "c" como argumento.
    * Como este botón no tiene color de fondo entonces es un botón transparente y se envía un False como parámetro.

Se debe hacer uso del servicio para crear los otros botones en la clase **LoginTemplate**. Si se corre la aplicación se puede verificar que corre perfectamente y se ve igual a como estaba, esto quiere decir que el servicio esta funcionando correctamente:

<div align="center">
  <img  src="https://i.imgur.com/OOamiHW.png">
  <p>Interfaz gráfica funcionando correctamente con la incorporación del servicio ObjGraficosService.</p>
</div>

El resto de métodos del servicio esta contenido dentro de este repositorio, puede observar todo el código  entrando a la carpeta **Clase4** luego a la carpeta **src/app** seguido de la carpeta **services** y entrando a la clase **objGraficosservice.java**. Allí podrá ver una versión actualizada del servicio con su debida documentación para empezar a implementarlos desde la clase **LoginTemplate** y así realizar la optimización del código. 
     
<div align="center">
  <img  src="https://i.imgur.com/6uuKnyw.png">
  <p>Carpeta Clase4 dentro del repositorio.</p>
</div>

<div align="center">
  <img  src="https://i.imgur.com/uCtHQzp.png">
  <p>Carpeta src/app dentro del repositorio.</p>
</div>

<div align="center">
  <img  src="https://i.imgur.com/lVCC4N1.png">
  <p>Carpeta services dentro del repositorio.</p>
</div>

<div align="center">
  <img  src="https://i.imgur.com/4ggxWx8.png">
  <p>Clase ObjGraficosService.java dentro del repositorio.</p>
</div>

<div align="center">
  <img  src="https://i.imgur.com/DWxmPOY.png">
  <p>Código del servicio dentro del repositorio.</p>
</div>

Una vez haya copiado todos los métodos de construcción en el servicio, este estará listo para usarse en todas las clases **template** que creemos posteriormente. Este servicio podrá usarse también en todos sus proyectos frontend para hacer más fácil la creación de objetos gráficos. Recuerde que cuando tenga el servicio completo podrá usarlo en la clase **loginTemplate** para la construcción de todos los objetos gráficos y probar que todo esta bien corriendo la aplicación.

**Nota:** Una particularidad que vale la pena recalcar es cuando creamos un JComboBox a traves del servicio, este recibirá un argumento llamado cadena que representa las diferentes opciones que contendrá el ComboBox y deberán enviarse separando cada una de las opciones con un **"_"** como se observa a continuación:

<div align="center">
  <img  src="https://i.imgur.com/fhbxKO4.png">
  <p>Ejemplo creación JComboBox con el servicio.</p>
</div>

# Optimización de recursos

Si ya hemos llegado hasta aquí hemos realizado una moduralización del código y ademas  una optimización de este. Pero aun podemos dar un paso más, vamos a ver la optimización de recursos. Esto intenta resolver la creación desproporcionada de objetos que estaremos creando en las clases UI. 

Tenemos que hallar una forma de controlar la creación de objetos que muy posiblemente usemos en varias clases. Por ejemplo los objetos decoradores son muy propensos a ser utilizados en diferentes clases. Es muy posible que el cursor que creamos para pasar sobre los botones lo usemos también en otras clases que tengan botones. El color Azul muy posiblemente lo usemos en la clase **VistaPrincipalTemplate** y en muchas otras más. 

Imaginen que por cada clase **template** que tengamos en un proyecto vamos a crear un objeto para el cursor o varios objetos para usar las mismas fuentes, colores, bordes o imágenes. La cantidad de recursos en memoria sería exorbitante.

Vamos a crear otro servicio llamado **RecursosService** y realizaremos el mismo mecanismo de única ejemplificación explicada previamente.

<div align="center">
  <img  src="https://i.imgur.com/bRJrFdi.png">
  <p>Creación de servicio Recursos en paquete Servicios.</p>
</div>

<div align="center">
  <img  src="https://i.imgur.com/Nx8rOax.png">
  <p>Creación de servicio Recursos.</p>
</div>

Ahora en la clase **loginTemplate** debemos igualmente obtener el objeto de este servicio:

**importación**
```javascript
import app.services.RecursosService;
```
**declaración**
```javascript
private RecursosService sRecursos;
```
**obtención de ejemplificación**
```javascript
sRecursos = RecursosService.getService();
```
Vamos a mirar que objetos decoradores se pueden usar en varias clases **template**:

* El cursor de mano para los botones seguramente se use en varias clases que tengan botones.
* Los colores también se usaran en varias partes del proyecto, es común que un proyecto entero de Interfaz Gráfica de usuario maneje una gama especifica de colores.
* Las fuentes se usaran claramente en otras clases, no todas las fuentes se usaran en todo el proyecto podrían existir unas particulares en una clase pero es bueno manejar una tipografía común en todas las interfaces del proyecto.
* El borde azul en la parte inferior es probable que lo usemos en otras clases que contengan JTextField.
* La imagen de cerrar ventana se podría volver a utilizar en la Vista principal.

Ahora vamos a realizar la creación de estos objetos decoradores en el servicio (los podemos crear dentro del constructor del servicio o en un método encargado de la creación de objetos decoradores dentro del servicio) y los borraremos de la clases **LoginTemplate**:

<div align="center">
  <img  src="https://i.imgur.com/v0fqj9J.png">
  <p>Objetos decoradores que se van a utilizar en varias partes del proyecto creados dentro del servicio.</p>
</div>

Note que el nombre de la variable **border** cambio a **borderInferiorAzul** esto ya que es muy probable que creemos más bordes en el proyecto y necesitamos ser específicos con cada uno de los objetos.

<div align="center">
  <img  src="https://i.imgur.com/4EJmd2a.png">
  <p>Objetos decoradores que serán necesarios unicamente en la clase LoginTemplate.</p>
</div>


<div align="center">
  <img  src="https://i.imgur.com/ixFsbMc.png">
  <p>El método crearObjetosDecoradores de la clase LoginTemplate con solo los objetos decoradores necesarios unicamente en esa clase.</p>
</div>

Ahora para que cualquier clase **template** pueda obtener estos objetos decoradores a traves del servicio necesitamos crear unos métodos **get** que nos retornen estos objetos:

```javascript
public Color getColorAzul(){
    return colorAzul;
}

public Color getColorGrisOscuro(){
    return colorGrisOscuro;
}

public Font getFontTPrincipal(){
    return fontTPrincipal;
}

public Font getFontTitulo(){
    return fontTitulo;
}

public Font getFontSubtitulo(){
    return fontSubtitulo;
}

public Cursor getCMano(){
    return cMano;
}

public Border getBorderInferiorAzul(){
    return borderInferiorAzul;
}

public ImageIcon getICerrar(){
    return iCerrar;
}
```

El servicio esta listo para ser usado. Ahora desde la clase **LoginTemplate** cuando necesitemos uno de estos objetos decoradores solo llamaremos al servicio seguido del método **get** que necesitemos. Mostraremos un ejemplo de esto:

<div align="center">
  <img  src="https://i.imgur.com/iRqg9SY.png">
  <p>Ejemplo de implementación de servicio de Recursos para obtener objetos decoradores compartidos entre clases.</p>
</div>

Se debe hacer esto con todos los objetos decoradores que eliminamos de la clase **LoginTemplate** y correr la aplicación para verificar que esta ocurriendo todo con normalidad.

<div align="center">
  <img  src="https://i.imgur.com/OOamiHW.png">
  <p>Interfaz gráfica funcionando correctamente con la incorporación del servicio RecursosService.</p>
</div>


Ahora si por ejemplo en la clase **VistaPrincipalTemplate** necesitamos utilizar alguno de estos objetos decoradores como el color Azul para dejar el fondo de la ventana con ese color ahora llamaremos al servicio para obtenerlo:

<div align="center">
  <img  src="https://i.imgur.com/2lGWovy.png">
  <p>Servicio Recursos utilizado en la clase VistaPrincipalTemplate para obtener el color azul.</p>
</div>


<div align="center">
  <img  src="https://i.imgur.com/KPu7F12.png">
  <p>Ventana VistaPrincipalTemplate.</p>
</div>

 Aunque el objeto decorador **colorAzul** se ve reflejado en dos clases distintas solo existe una vez en memoria. De igual forma el servicio **RecursosService** solo existirá una vez en memoria sin importar en cuantas clases lo llamen.

# Orden adicional

Si alguno de los métodos de creación hasta el momento queda demasiado largo es posible que sea difícil identificar donde esta cada objeto gráfico, una buena forma de dar un orden es mediante comentarios que servirán de títulos y guiás indicándonos donde esta cada objeto gráfico, esto no es obligatorio y personalmente es preferible usarlo en métodos de creación que quedan muy largos, en este caso se realizara para los métodos **crearJButtons** y **crearJLabels**:

<div align='center'>
    <img  src='https://i.imgur.com/Q7J2H0M.png'>
    <p>Creación de comentarios que guian la creación de objetos gráficos</p>
</div>

# Resultado

Si has llegado hasta aquí **!Felicidades!** ahora no solo tienes una interfaz gráfica agradable para el usuario, también tienes un código mucho más organizado, modularizado, optimizado, responsable con los recursos y mantenible.

En la siguiente clase vamos a revisar el concepto de Componente gráfico y su importancia en la creación de interfaces gráfica con proyectos grandes. También nos introduciremos a los eventos empezando con los eventos básicos de botones.

# Actividad

Implementa los servicios de creación de objetos gráficos y de recursos para agregar optimización de código y recursos en sus Login propios.  Ademas de realizar modularizacion en el código.