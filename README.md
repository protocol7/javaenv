# javaenv

A Java version manager heavily inspired by
[rbenv](https://github.com/rbenv/rbenv) and
[tfenv](https://github.com/tfutils/tfenv). `javaenv` manages your installed
Java versions and allows for keeping the Java version for a project under
version control.

## Why not jEnv?

[jEnv](https://github.com/jenv/jenv) is a great tool with similar goals.
However, I wanted javaenv to manage the full life cycle of the Java
environment, including installation, in order to simplify some workflows.

## Support

javaenv supports Linux and Mac OS X. Support for Windows should be doable but
is not on my roadmap.

## Installation

### Using git

```
git clone https://github.com/protocol7/javaenv.git ~/.javaenv
```

`javaenv` is a self-contained script and requires Python 3.3 or newer to run.

For convenience, add `javaenv` to your $PATH, e.g. using:

```
ln -s ~/.javaenv/javaenv /usr/local/bin
```

Shim the Java command line tools:

```
ln -s ~/.javaenv/javaenv /usr/local/bin/java
ln -s ~/.javaenv/javaenv /usr/local/bin/javac
...
```

This will allow you to automatically switch version for `java`, `javac` and
other tools, for example:

```
$ cd my-java-project
$ cat .javaversion
openjdk-11.0.2
$ javac -version
javac 11.0.2
```

## Usage

### Versions

Versions, as provided as command line arguments or in `.javaversion` files are
in the format of `<distribution>-<version>`. Supported distributions are:

* `adoptopenjdk`
* `corretto`
* `openjdk`
* `oracle`

A valid version would be, for example, `openjdk-11.0.2`.

The version can for some commands and for `.javaversion` files exclude the
distribution, in which case `openjdk` is used as the default. Thus, a valid
version can also be, for example, `11.0.2`.

### .javaversion

If a version is not provided for a command, or when calling Java command line
utilities, the version will be read from a file called `.javaversion` in the
current directory. This file should contain only the version, as defined above,
for example:

```
echo 'openjdk-11.0.2' > .javaversion
```

It is recommended that `.javaversion` is kept under version control with your
source code. This allows contributors to easily install and use the correct
Java version.

### javaenv install [version]

Installs a version of the JDK. The version to install can either be provided to
the command, or read from a `.javaversion` file. if the version is already
installed, this is a no-op. Thus, when starting work on a project using javaenv
you can simply run to be all set up:

```
javaenv install
```

### javaenv uninstall version

Uninstall a specific version. The version must include the distribution name.

### javaenv list

List locally installed versions

### javaenv list-remote

List all versions available for installation.

### javaenv home [version]

Print the value for `JAVA_HOME` for the active version. The version can either
be provided to the command, or read from a `.javaversion file`. The command is
useful for tools using `JAVA_HOME`, e.g. Maven.

```
export JAVA_HOME=$(javaenv home)
```

## Verification of installations

When downloading installation files, javaenv will verify the expected SHA256/MD6
hash.  Note that the expected hash is stored in the `javaenv` command itself,
so this requires you to trust your javaenv installation.

## TODO

* Add support for automatically shimming Java command line tools
* Add all released and still available versions
* Add support for building Docker images
* Add direct support for setting Java version for Maven
* [Long term] Remove need for Python
