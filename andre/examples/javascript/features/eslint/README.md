# Linters and Javascript

Javascript's quirks and features make a language that is very advantaged by use of 
a 'linter'.

Serious users of modern javascript need a method of constraining the different
development patterns possible in javascript. A Linter is a powerful way of doing this. 

A linter reads the project code, and validates that it conforms to a set of rules
(this is one form of static analysis, and a linter works like the front end of a compiler!)

Any serious development team using javascript should use a linting system, and prevent
contributions and releases of code that does not pass ALL the rules agreed on by the team.

## Javascript linter summary:

Thematic with Javascript, there are many different ways to accomplish this. 

### JSLint - original JS linter.

Not configurable and strict rules. 

Get started with JSLint: 

    curl -L https://www.jslint.com/jslint.mjs > jslint.mjs

Then

    node jslint.mjs <your program here>.js

### ESLint

ESLint is no doubt the more popular and "modern" javascript linter. I'd recommend it

# Using ESLint

Using ESLint in a project requires the following: 

1. nodejs and npm
2. .eslintrc file (this stores the configuration for the linter)

There are sooooo many options though! See https://eslint.org/docs/latest/rules/ for the 
full reference. 

Where do you begin? 

Fortunately, ESLint allows extension of existing sets of rules. 

One of the most popular is the set developed by AirBnB for use in their development teams. https://github.com/airbnb/javascript

To get started with their base configuration, execute this with NPM 5+

    npx install-peerdeps --dev eslint-config-airbnb-base

This adds the following (versions may differ) to package.json

    "devDependencies": {
        "eslint": "^8.57.0",
        "eslint-config-airbnb-base": "^15.0.0",
        "eslint-plugin-import": "^2.29.1"
    }

There are only two steps remaining. First, create a .eslintrc file in your project, with the
following configuration:

    {
        "extends": "airbnb-base"
    }

Next, add a helpful run script to your package.json

    "scripts": {
        "lint" : "./node_modules/.bin/eslint"
    }

At this point, your project is ready to be linted! In this repository, check out all
the problems with my app.js by running: 

    npm run lint app.js

## IDE Plugins

Microsoft offers a plugin for VSCode that integrates linting errors and checks 
directly into the IDE for developing Javascript with ESLint. 

## Modifying the linting rules

There are a great many rules provided by the AirBnB base config, some of which may not fit
with your use case. One example is the 'no-console' rule. airbnb-base is designed to 
lint code that runs on a browser, not on the server, although it still works well for that. 

In a server application, console.log() is a useful construct. 

To disable this warning in our configs, use the following modification of .eslintrc

    "rules": {
        "no-console": "off"
    }