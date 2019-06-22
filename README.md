# spring-game

# Autowiring Beans
- @Autowired annotation may also be used with constructor and setter based dependency injection.
- @Autowired annotation can be added to parameters of a constructor or setter method
- The recommended and best practice is to use constructor based dependency injection. Although in some cases 
  this is not possible and field injection will have to be used.
- The Spring team generally recommends constructor injection as it enables you to implement application components as
immutable objects and to ensure that required dependencies are not null.

# Component Scanning
- Spring provides several sterotype annotations such as `@Component`, `@Service` and `@Controller`.
- The word stereoptype means something conforming to a fixed or general pattern.
- This is quite logical because it is recommended that you annotate your Controller classes with `@Controller`,
Service classes with `@Service`, and so on.


**A Stereoptype annotation is a marker for any class that fulfills a role within an application.**
- The benefit to using a Stereoptype annotation is that it greatly cuts down on the need to use Spring XML based
configuration for the given component.

**`@Component` is a generic stereotype for any Spring-managed component.`**
- `@Repository`, `@Service`, and `@Controller` are specialization of `@Component` for more specific use cases,
for instance, in the persistence, service, and presentation layers respectively.