# spring-game

## Autowiring Beans
- @Autowired annotation may also be used with constructor and setter based dependency injection.
- @Autowired annotation can be added to parameters of a constructor or setter method
- The recommended and best practice is to use constructor based dependency injection. Although in some cases 
  this is not possible and field injection will have to be used.
- The Spring team generally recommends constructor injection as it enables you to implement application components as
immutable objects and to ensure that required dependencies are not null.

## Component Scanning
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

## Using Java Annotation Configuration

Instead of defining an application's configuration using XML, we are able to use Java Annotation Configuration, so
configuration meaning we can define our application's configuration in a Java class file.
- Decorating the Java class used for configuration with the `@ComponentScan` annotation allows for automatic discovery
of the beans to be configured (given an accurate `basePackages` argument is given to the `@ComponentScan` annotation).
For this to work the modules classes must be decorated with an appropriate *stereotype* annotation i.e `@Component`,
`@Service` or `@Controller`
- **An alternative way** can be used to discover beans if one does not want to use ComponentScanning. Methods can be
specified as part of the App Configuration Java class that return instance of beans. **This approach is sometimes
preferred as it allows for one to perform some additional setup before instantiating a particular Bean. This approach
helps to write type safe code.**

## Application Events

The `ApplicationContext` interface has a parent interface `ApplicationEventPublisher` that encapsulates event 
publication functionality, this is an additional capability of `ApplicationContext`.
- Event handling in the `ApplicationContext` is provided through the `ApplicationEvent` class and `ApplicationListener`
interface.
- If a bean that implements the `ApplicationListener` interface is deployed into the context, every time an 
`ApplicationEvent` (custom events may also be used) gets published to the `ApplicationContext`, that bean is notified.

**This follows the standard Observer design pattern.**