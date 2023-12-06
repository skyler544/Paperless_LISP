# Paperless
[Paperless-ngx](https://docs.paperless-ngx.com/)

## Authors:
-  Comberlato Bampi, Julio
-  Gamsjäger, Peter
-  Mayfield, Skyler

## Technology Stack
-  JDK 17
-  Spring Boot
-  RabbitMQ
-  PostgreSQL
-  GitHub Actions

## Project specific branch naming convention
| Category | Description                        |
|----------|------------------------------------|
| bugfix   | for fixing a bug                   |
| hotfix   | for quickly fixing critical issues |
| test     | for experimenting and testing      |
| feature  | for adding or removing features    |

### Branch naming example

- Template: "category/ { issue name }"
- Example: feature/3-login-for-cool-website

## GitHub actions

The project contains two gitHub actions, namely:

  - Main CI
    - The action is triggered on push into main branch (e.g. after a PR was approved and completed)
    - The action builds the version of the paperlessREST project from the main branch and publishes the build artifact on gitHub

  - Test CI
    - The action is used as a status check for pull requests against main. It was implemented to guarantee that only tested code is pushed into main
    - The action builds and tests the actual version of the paperlessREST project, if any tests fail the pull request cannot be completed
   
  ## How to write better commit messages
  
    - Why have I made these changes?
    - What effect have my changes made?
    - Why was the change needed?
    - What are the changes in reference to?

    e.g. git commit -m 'Add margin to nav items to prevent them from overlapping the logo'

    source: https://www.freecodecamp.org/news/how-to-write-better-git-commit-messages/
