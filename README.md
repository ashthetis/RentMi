# RentMi Android

The RentMi Android app.

Technology         | Purpose
-------------------|----------
**Java**           | Core
**Android API 16** | Target API
**Android Studio** | IDE

Library            | Purpose
-------------------|----------
**Fabric**	       | Analytics, Crash Reporting
**Retrofit**	   | Networking
**Epoxy**	       | RecyclerView Adapter

### Contributing

Keep all contributions in your own branch, and send a pull request when you are ready to have it reviewed. If a code review has been approved, the branch will get merged into the master branch.

### Conventions

Consistent code conventions are very important. Your pull requests may be rejected if they do not follow the conventions of the project.

##### Class Names

Classes should be named as clear as possible. For Activities, class names should be suffixed with "Activity" (e.g. MainActivity). Fragments should be suffixed with "Fragment" (e.g. HomeFragment). Always use PascalCase for class names.

##### Function Names

Functions should be named in camelCase.

##### Variable Names

Variables should be named in camelCase. Member variables should be prefixed with "m_" (e.g. m_textView).

##### Curly Braces

Curly braces deserve their own lines. Give it to them.
Also, never skip braces. Even if an if statement contains a simple one liner, it should be surrounded by curly braces.

##### Documentation

Please use JavaDoc to document classes, and functions when applicable.