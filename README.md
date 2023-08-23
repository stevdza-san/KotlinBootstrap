<p align="center">
  <a href="#">
    <img src="/ASSETS/logo.svg" alt="Kotlin-Bootstrap logo" width="200" height="165">
  </a>
</p>

<h3 align="center">Kotlin Bootstrap</h3>
<p align="center">
  ⚡Highly experimental library built on top of the <a href="https://github.com/varabyte/kobweb" target="_blank" rel="noopener noreferrer">Kobweb</a>(Compose HTML framework). It allows you to use the official <a href="https://getbootstrap.com/" target="_blank" rel="noopener noreferrer">Bootstrap</a> UI components with Kotlin and Jetpack Compose, to build a frontend.
</p>


## Available Components
- [Button](#button)

## Usage
Coming soon

## Button
<p>
  <img src="/ASSETS/buttons.png" alt="Buttons Preview" width="540">
</p> 

<p>
  <img src="/ASSETS/LoadingButton.gif?raw=true" width="268"/>
  <img src="/ASSETS/LoadingButtonText.gif?raw=true" width="268"/>
    <img src="/ASSETS/BadgeButton.gif?raw=true" width="268"/>
</p>

<p>A simple button usage:</p>

```kotlin
BSButton(
    text = "Sign in",
    onClick = {}
)
```

<p>You can update your button state to loading, as well as specify the exact Loading Text <em>(optional)</em>:</p>

```kotlin
var buttonLoading by remember { mutableStateOf(false) }
BSButton(
    text = "Sign in",
    loading = buttonLoading,
    loadingText = "Please wait...",
    onClick = { buttonLoading = true }
)
```

<p>Add a Badge to your button:</p>

```kotlin
BSButton(
    text = "Shopping Cart",
    badge = ButtonBadge(
        text = "10"
    ),
    onClick = {}
)
```
