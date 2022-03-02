# Intellum Coding Challenge

## The challenge

We would like you to complete a short coding task. It will not be evaluated on performance or completeness. The goal is to see...

1. How you work with Git.
2. How you approach solving a problem.
3. How readable your code is.

Please make sure that you commit to git regularly, push it to GitHub, and send us a link to the repository.

### Example Text

“Version 2.3 of the new ACME widget is now live! Special thanks to @[Joe Bloggs](567) and @[福 岡 正信](123) for all their hard work on getting this out the door. @[Joe Bloggs](567) will be monitoring adoption for the next three weeks.”
> Note: The text in the form of @[Full Name](User_ID) represents a tag similar to Twitter and Facebook.

### Task
- Create a method for converting the text into markdown with the tag linked to https://example.com/users/[User_ID] and the linked text being just the user’s full name preceded by an @.

> If you have any questions, feel free to ask Stephen at swilliams@intellum.com (Timezone NZDT (GMT+13)).

## Implementation

### 1. Getting started

Clone the solution from [GitHub](https://github.com/henriquecocito);

```bash
git clone git@github.com:henriquecocito/intellum.git
```

### 2. Running
Open the solution directory in your terminal and run the following command:

```bash
./gradlew run
```
	
## Contributing

### 1. Pre requisites

- Android Studio
- IntelliJ IDEA

### 2. Architecture

This project follows the **Clean Architecture** and it has been separated into the following layers:

- **Domain**: Responsible for holding all application use cases;
- **Entities**: Responsible for holding all business rules and models;
- **Presentation**: Responsible for handling all ui interactions.

### 3. Testing

All the layers mentioned above are fully covered by unit tests.
To run these unit tests, open the solution directory in terminal and run:

```bash
./gradlew tests
```

### 4. CI & CD
This solution has a simple workflow on [GitHub Actions](https://github.com/henriquecocito/intellum/actions) to prevent us integrating a code that is broken into main branch.

This workflow runs when a pull request is opened or updated.

## Considerations
I know that all this structure isn't necessary to create a solution to resolve this coding challenge, but I chose to do this way to show you some of my knowledge.

## Author
[@henriquecocito](https://github.com/henriquecocito)