# runtrack_java_spring-jour1

### Qu'est-ce que Spring Initializr et comment peut-il faciliter la création d'un nouveau projet Spring ?
Spring Initializr est un outil en ligne (utilisable via des IDE comme IntelliJ ou des suites de logiciel comme Spring Tools Suite) qui permet de générer rapidement la structure de base d'un nouveau projet Spring.

### Pourquoi le fichier pom.xml est-il crucial dans un projet Maven ?

Cela permet d'éviter de configurer manuellement le projet. Le fichier pom.xml configure tout le projet.

### Le controller dans le contexte de Spring MVC se charge de la communication entre le modèle et la view.
Il fait le lien entre notre code et le framework qui va pouvoir renvoyer la page HTML.

### Question : Comment Spring permet-il l'injection de propriétés depuis des fichiers de configuration ?

Les propriétés définies dans les fichiers de configurations (application.properties ou application.yml) peuvent être injectées dans des composants.
Spring va se charger d'aller récupérer les valeurs des propriétés se trouvant dans les fichiers de configuration. Cette fonctionnalité nous permet ensuite d'utiliser le décorateur @Value et d'injecter la valeur voulu dans la variable de notre choix

### Question : Pourquoi serait-il utile d'avoir différents profils dans une application Spring ?

Il est très utile et important d'avoir des configurations différentes afin de mieux gérer les différents environnements. Le plus connu est l'environnement de développement qui ne demande pas du tout les même configurations que l'environnement de production. L'environnement de dev va plus se concentrer sur des configurations qui permet de tester rapidement et avoir les modifications du code sans avoir à relancer l'application par exemple alors que pour la production, l'important et d'avoir l'environnement le plus efficient pour l'utilisation.

### Qu'est-ce que JPA et comment facilite-t-il l'accès aux bases de données ?

Spring Data JPA fournit une implémentation de la couche d'accès aux données pour une   
application Spring. C'est une brique très pratique car elle permet de ne pas réinventer  
la roue de l'accès aux données à chaque nouvelle application et donc de se concentrer sur  
la partie métier.

### Question : Pourquoi les bases de données en mémoire, comme H2, sont-elles utiles pendant le développement ?

Cela permet d'avoir d'émuler la phase de production de l'application sans avoir besoin de modifier la véritable base de données.
L'avoir en mémoire permet une plus grande rapidité d'exécution pour les tests

### Question : Quelle est l'importance des annotations, telles que @Entity, dans le contexte de JPA ?

Les annotations comme @Entity permet de faire le lien entre le code Java et JPA (Java Persistence API) qui va communiquer avec la base de données.
Cela va permettre de facilement mapper entre l'objet et la table et vice versa.
Les autres annotations permet de paramètrer les différents éléments qui doivent pouvoir être en lien avec la base de données.
@Id permet d'identifier la clé primaire d'une table dans un objet, @GeneratedValue permet de spécifier que la valeur doit être générée automatiquement et pas manuellement.
Cela permet de faire du SQL sans faire de requête directement et de se concentrer sur la logique métier de l'application

### Comment Spring Data facilite-t-il la création de requêtes de base de données?

Spring Data JPA réduit le code standard, promeut les meilleures pratiques et améliore   
la productivité des développeurs en offrant un moyen pratique d'interagir avec les   
bases de données relationnelles tout en conservant la flexibilité nécessaire pour   
personnaliser les requêtes et les comportements lorsque cela est nécessaire.

### Comment pouvez-vous créer et lire des entités avec Spring Data JPA ?

Pour créer et lire des entités avec Spring Data JPA, on définit une interface qui étend JpaRepository.

Cela nous donne déjà accès aux méthodes CRUD comme save() pour insérer ou mettre à jour, et findAll() / findById() pour lire. On peut aussi déclarer des méthodes personnalisées, par exemple User findByEmail(String email), que Spring implémente automatiquement.

### Comment la méthode save de Spring Data JPA peut-elle être utilisée à la fois pour la création et la mise à jour ?**

La méthode save() de Spring Data JPA fait à la fois création (INSERT) et mise à jour (UPDATE) grâce au comportement de JPA/Hibernate qui se base sur la clé primaire (@Id) de l’entité :

**Si l’entité n’a pas encore d’ID (ou que l’ID n’existe pas en base):**
    
    save() effectue un INSERT → création d’un nouvel enregistrement.

**Si l’entité a déjà un ID correspondant à une ligne existante en base:**
    
    save() effectue un UPDATE → la ligne est modifiée avec les nouvelles valeurs.