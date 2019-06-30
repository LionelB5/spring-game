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

## Qualifiers

**When there is a need for fine-tuning annotation-based autowiring we can use qualifiers.**
- A qualifier is an annotation that you apply to a bean.
- *The `@Primary` annotation is an effective way to use autowiring by type with several instances, when one primary 
candidate can be determined.*
- **When more control over the selection process is required**, the `@Qualifier` annotation can be used.

Qualifier values can be associated with specific arguments, narrowing the set of type matches so that a specific bean 
is chosen for each argument.
- You can create your own custom qualifier annotations. Simply define an annotation and provide the `@Qualifier` 
annotation within your definition. 

## Loading values from a file

Spring makes it easy to load values from a file
- The `@PropertySource` annotation may be added to a class to indicate the location of the properties file to load from.
- To inject properties from this file into a field, method, constructor parameter etc. we can use placeholders.

The `@Value` annotation can be used to indicate which value should be loaded from the configuration file i.e 
`@Value('${game.maxNumber:20}')`.
- The `@Value` annotation is used for **expression based dependency injection**.

## Lombok

**Lombok is a Java library that helps generate boilerplate code.**
- Lombok uses the Annotation processor API.
- Using Lombok we don't have to write **getters** and *setters* and many other methods that are very commonly used like
**equals()**, **hashCode()** and **toString()**.

### Some Lombok annotations
`@Getter`
- We can annotate any field to elt Lombok generate the default getter automatically.
- A default getter returns the field, and is named `getName` if the field is called name 
(or `isName` if the field's type is `boolean`)

`@Setter`
- A default setter is named `setName` if the field is called name, returns void, and takes a parameter of the same 
type as the field. It simply sets the field to this value.

`@ToString`
- Generates boilerplate code for the toString method.

`@EqualsAndHashCode`
- Generates equals and hashCode methods.

`@RequiredArgsConstructor` 
- Generates a constructor with required arguments.

`@Slf4j`
- Generates a private static final field for SLF4J logger.

`@Data`
- Generates boilerplate code for POJO (Plain Old Java Object).
- It combines `@Getter`, `@Setter`, `@ToString`, `@RequiredArgsConstructor`, and `@EqualsAndHashCode`.
- Constructor is not generated if it has been declared already.