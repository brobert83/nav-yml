This repo illustrates how to setup a Spring boot app using yml based properties

By using this setup navigation is possible from the application.yml file to where the properties are bound in code, and back (Crtl+B, Crtl+click, etc)

Notice this dependency in pom.xml
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>

```
### How to enable annotation processing in Intellij
![alt text](https://github.com/brobert83/nav-yml/blob/master/github-content/intellij_enable_annotation_processing.png?raw=true)

### Properties not bound are highlighted

![alt text](https://github.com/brobert83/nav-yml/blob/master/github-content/unbound_property.png?raw=true)

### The magic
This is what is basically needed, then just inject that bean wherever
```
@Configuration
@ConfigurationProperties("my.living.rent")
class Address {

    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
```

Also, @EnableConfigurationProperties 
```
@SpringBootApplication
@EnableConfigurationProperties
public class NavYmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(NavYmlApplication.class, args);
    }

}

```
### This is how it should look in the class, by clicking those green leafs the ide will take you to the location in the yml where that prop is declared
![alt text](https://github.com/brobert83/nav-yml/blob/master/github-content/nav_from_code.png?raw=true)

#### Notes:
- it does not work in combination with Lombok (@Getter @Setter)
- the annotation processing must be enabled in Intellij
- I've noticed that sometimes the IDE needs some time to make the binding happen
