# spring-game

# Autowiring Beans
- @Autowired annotation may also be used with constructor and setter based dependency injection.
- @Autowired annotation can be added to parameters of a constructor or setter method
- The recommended and best practice is to use constructor based dependency injection. Although in some cases 
  this is not possible and field injection will have to be used.
- The Spring team generally recommends constructor injection as it enables you to implement application components as
immutable objects and to ensure that required dependencies are not null.
