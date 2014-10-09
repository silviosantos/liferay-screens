# Liferay Screen Theme Creation for iOS

## Important Note

*This product is under heavy development and its features aren't ready for use in production. It's being made public only to allow developers to preview the technology*.

## Introduction

This document explains the steps to create your own theme in order to give your screenlets different look and feel or behaviour

Before read this guide, you may read the [architecture guide](architecture.md) in order to understand the underlying concepts.

It may be useful to read the [How to Create Your Own Screenlet Guide](screenlet_creation.md).

The first step is to decide the kind of your new theme:
- **Full theme**
- **Child theme**
- **Extended theme**

For more details on the kind of themes, refer the [Themes secion in the architecture guide](architecture.md#theme-layer).

For the following steps, we supose you want to create a new theme for the `LoginScreenlet`

###Full theme

Our theme will present a completely different layout, using different components and input data: it will present just one single `UITextField` to type the user name, and the password used will be the [UDID](http://www.idownloadblog.com/2010/12/21/iphone-udid/). 

1. Create a new `xib` called `LoginScreenlet_full.xib`. You'll build your new UI here as usual with Interface Builder. A good start is to duplicate `LoginScreenlet_default.xib` and use it as a template. Insert the text field for the user name and a _Sign In_ button with same `restorationIdentifier` as default's theme button. 
	![New xib for full theme](Images/xcode-full-theme.png)
1. Create a new _view_ class called `LoginScreenletView_full`. As previously, you can duplicate `LoginScreenletView_default` class and use it as a template. In this class, add all `@IBOutlet` properties or `@IBAction` methods you need to bind your UI components. This class has to inherit `BaseScreenletView` class and conform the `LoginScreenletData` protocol, implementing corresponding the getters and setters. In our case, the `password` getter will return the UDID.

1. Set `LoginScreenletView_full ` as the Custom Class of your `LoginScreenlet_full.xib ` file and bind your `@IBOutlet` and `@IBAction` to your class.

1. Install the new theme, insert the `LoginScreenlet` in any of your view controllers, and use `full` value as `themeName` screenlet's property. Your new look and feel will be shown in Interface Builder.


###Child theme

Our theme will present the same components as _Default_ theme, but adjusted to a larger resolution (iPad, iPhone 6 or whatever).

1. Create a new `xib` called `LoginScreenlet_large.xib`. You'll build your new UI here as usual with Interface Builder. A good start is to duplicate `LoginScreenlet_default.xib` and use it as a template.
	![New xib for child theme](Images/xcode-child-theme.png)
1. Change the position, size or whatever property of the parent components. Don't change neither Custom class, outlet connection nor `restorationIdentifier`.

1. Install the new theme, insert the `LoginScreenlet` in any of your view controllers, and use `large` value as `themeName` screenlet's property. Your new look and feel will be shown in Interface Builder.


###Extended theme

Our theme will present the same components as _Default_ theme, but setting new translated strings and with few new animations. We also introduce a new UI component to configure whether or not the password will be shown when typed. 

Refer to _[Flat7 theme source code](https://github.com/liferay/liferay-screens/tree/master/ios/Library/Themes/Flat7)_ for an actual sample of this kind of themes.


1. Create a new `xib` called `LoginScreenlet_ext.xib`. You'll build your new UI here as usual with Interface Builder. A good start is to duplicate `LoginScreenlet_default.xib` and use it as a template. Add new `UISwitch` component to configure password presentation.
	![New xib for extended theme](Images/xcode-ext-theme.png)
1. Create a new _view_ class called `LoginScreenletView_ext` using `LoginScreenletView_default` as parent class. In order to set new translations, you can override `onSetTranslations` method. For other customizations, consider override other parent's methods or add new delegates to the class. Add new `@IBOutlet` or `@IBAction` for the new `IBSwitch` component.

1. Set `LoginScreenletView_full ` as the Custom Class of your `LoginScreenlet_ext.xib ` file and bind your new `@IBOutlet` and `@IBAction` to your class.

1. Install the new theme, insert the `LoginScreenlet` in any of your view controllers, and use `ext` value as `themeName` screenlet's property. Your new look and feel will be shown in Interface Builder.