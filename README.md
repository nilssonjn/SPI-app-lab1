# Java SPI Application Lab 1

This is a simple console application that demonstrates the use of the Java Service Provider Interface (SPI). It includes an interface for a weather app service and two different implementations of this service. The application allows you to dynamically load the implementations at runtime and choose which one to use.

## Task

- **Service Definition**: Define an interface for a service. This can be a simple service such as currency conversion or something more complex with multiple methods.
- **Implementations**: Create at least two implementations of the defined interface. These implementations should be able to be loaded dynamically when the application starts.
- **User Interaction**: Allow the user to choose which implementation they want to use. The application can use one or all implementations based on the user's selection to perform the tasks

## Installation

To run the application, follow these steps:

1. Clone this repository:

    ```bash
    git clone https://github.com/your-username/java-spi-app.git
    ```

2. Navigate to the project directory:

    ```bash
    cd java-spi-app
    ```

3. Compile the Java source files:

    ```bash
    javac -d bin src/*.java
    ```

4. Run the application:

    ```bash
    java -cp bin your.package.Main
    ```

## Usage

1. When you run the application, you will be prompted to choose which implementation you would like to use as a weather service.
2. After making your selection, the application will ask you for the location you want to see the weather for.
3. The application will then show the weather using the selected provider and display the result.
