# ENUNCIADO:

Se pide diseñar una interfaz gráfica de usuario (**prototipo** de aplicación de escritorio) para
una aplicación para la **gestión de proyectos/tareas** usando JFC (Swing). El alumno deberá
centrarse en:

* El diseño de ventanas y posicionamiento de controles.
* La consistencia del diálogo y del diseño.
* El diseño de formularios y listados de información.
* El diseño del lenguaje visual (iconos) y textual (mensajes de aviso, error, ayuda al
usuario, etc.).
* Comprobación de las entradas de información por parte del usuario; proporcionar
feedbacks adecuados, etc.

# FUNCIONALIDADES:

A continuación indicamos una serie de **funcionalidades** que sería conveniente que incluyera
la aplicación a desarrollar.

* El **usuario** de la aplicación será el **gestor del proyecto**.
* La aplicación permitirá, entre otros:
    * Acceso mediante identificación y clave (ventana de login).
    * Selección del idioma deseado. La aplicación estará internacionalizada (al menos en dos idiomas: español e inglés).
    * Una vez que el usuario se ha autenticado en el sistema, y una vez en la aplicación, ésta mostrará los datos de la persona que accede, así como la fecha del último acceso.
    * Posibilidad de salir de la aplicación en cualquier momento.
    * Ayuda.
    * Capacidad de adaptación (opcional).
* Gestión de **proyectos**:
    * Posibilidad de consultar el listado de proyectos.
    * Posibilidad de añadir, borrar y editar proyectos.
    * Seleccionar un proyecto para acceder a su información. Entre los detalles de un proyecto se podrán incluir: el nombre, descripción, fecha de creación, miembros del equipo, responsable del proyecto...
    * Posibilidad de añadir, borrar, editar y listar **tareas asociadas a un proyecto**. En cuanto a
la consulta de tareas, éstas podrán mostrarse en formato de lista o calendario. En el caso
de mostrarse en formato de lista, las tareas se podrán agrupar en secciones o categorías.
Entre los criterios de agrupación podrán usarse la fecha de creación, la de finalización, el
usuario responsable, la prioridad o el estado en que se encuentra la tarea (por ejemplo,
completadas, activas, tardías, etc.).
    * Seleccionar una tarea para acceder a su información. Entre los detalles de una tarea se
podrán incluir: nombre de la tarea, usuario encargado de su realización, fecha de
creación, fecha de finalización, etiquetas, e incluso subtareas, y comentarios asociados,
etc...La aplicación podrá dar la opción de asociar imágenes (gráficos, mapas
conceptuales, ...) a las tareas, dando la opción de poder editar dichas imágenes para
incluir anotaciones.
    * La aplicación dará la posibilidad de cambiar el estado de una tarea (por ejemplo, indicar
que una tarea ha sido completada).
    * Posibilidad de asignar usuarios a proyectos y a tareas. Los usuarios añadidos/asignados
a un proyecto pueden ser asignados a varias tareas de un proyecto (pudiendo desempeñar
distintos roles, tales como, responsable de tarea, etc...).
    * Posibilidad de añadir, borrar, editar y listar usuarios.
    * Posibilidad de consultar la ficha de un determinado usuario. Entre la información a
mostrar de un usuario podrá incluirse: nombre, foto identificativa, rol, proyectos y/o
tareas a las que está asignado, información de contacto, conocimientos/habilidades, etc...
    * La aplicación dará la posibilidad del envío de mensajes a usuarios. En dichos envíos
pueden adjuntarse recursos (informes, imágenes, ...).
    * La aplicación contará con una funcionalidad para la creación de anotaciones en
imágenes. 
