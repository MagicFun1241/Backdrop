[![](https://jitpack.io/v/DzutsevGeorgy/Backdrop.svg)](https://jitpack.io/#DzutsevGeorgy/Backdrop)
[![Release](https://jitpack.io/v/ru.dzgeorgy/Backdrop.svg)]
(https://jitpack.io/#ru.dzgeorgy/Backdrop)
# Backdrop
Easy way to implement 'backdrop' component!

## Screenshots
Screenshot #1 | Screenshot #2 | Screenshot #3
------------- | ------------- | -------------
![Screenshot #1](https://raw.githubusercontent.com/DzutsevGeorgy/Backdrop/master/imgs/Screenshot_20190209-020158_Backdrop_Sample.png) | ![Screenshot #2](https://raw.githubusercontent.com/DzutsevGeorgy/Backdrop/master/imgs/Screenshot_20190209-020207_Backdrop_Sample.png) | ![Screenshot #3](https://raw.githubusercontent.com/DzutsevGeorgy/Backdrop/master/imgs/Screenshot_20190209-020218_Backdrop_Sample.png)

## Installing
Add this in your root **build.gradle**
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Then add the dependency
```gradle
dependencies {
  implementation 'com.github.DzutsevGeorgy:Backdrop:v1.0'
}
```

## Implementing
1. Add backdrop component to your layout
2. Set open and close icons
3. Set back and front layout
```xml
<ru.dzgeorgy.backdrop.BackdropLayout
  android:id="@+id/backdrop"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  app:close_icon="@drawable/ic_close"
  app:open_icon="@drawable/ic_filter_list">
  
    <include layout="@layout/back_layer" />
    <include layout="@layout/front_layer" />
    
</ru.dzgeorgy.backdrop.BackdropLayout>
```
4. In your activity or fragment call this
   1. For **Toolbar**, where **_toolbar_** is your Toolbar
   ```kotlin
   backdrop.setupWithToolbar(toolbar)
   ```
   1. For **MenuItem**, where **_menuItem_** is item of your menu
   ```kotlin
   backdrop.setupWithMenuItem(menuItem)
   ```
    **_Note that before calling this method your menu must be inflated_**  
    I can recommend call this in `onPrepareOptionsMenu`
5. Also you can hide and show backdrop with this methods  
`backdrop.showBackdrop()` for showing backdrop  
`backdrop.hideBackdrop()` for hiding backdrop  
`backdrop.toggleBacokdrop()` for hiding and showing backdrop  
## Changelog
- v1.0  
  - Initial release
