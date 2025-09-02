# runtrack_java_spring-jour1

### Qu'est-ce que Spring Initializr et comment peut-il faciliter la création d'un nouveau projet Spring ?
Spring Initializr est un outil en ligne (utilisable via des IDE comme IntelliJ ou des suites de logiciel comme Spring Tools Suite) qui permet de générer rapidement la structure de base d'un nouveau projet Spring.

### Pourquoi le fichier pom.xml est-il crucial dans un projet Maven ?

Cela permet d'éviter de configurer manuellement le projet. Le fichier pom.xml configure tout le projet.

### Le controller dans le contexte de Spring MVC se charge de la communication entre le modèle et la view.
Il fait le lien entre notre code et le framework qui va pouvoir renvoyer la page HTML.

### Question : Comment Spring permet-il l'injection de propriétés depuis des fichiers de configuration ?**

Les propriétés définies dans les fichiers de configurations (application.properties ou application.yml) peuvent être injectées dans des composants.
Spring va se charger d'aller récupérer les valeurs des propriétés se trouvant dans les fichiers de configuration. Cette fonctionnalité nous permet ensuite d'utiliser le décorateur @Value et d'injecter la valeur voulu dans la variable de notre choix

### Question : Pourquoi serait-il utile d'avoir différents profils dans une application Spring ?**

Il est très utile et important d'avoir des configurations différentes afin de mieux gérer les différents environnements. Le plus connu est l'environnement de développement qui ne demande pas du tout les même configurations que l'environnement de production. L'environnement de dev va plus se concentrer sur des configurations qui permet de tester rapidement et avoir les modifications du code sans avoir à relancer l'application par exemple alors que pour la production, l'important et d'avoir l'environnement le plus efficient pour l'utilisation.