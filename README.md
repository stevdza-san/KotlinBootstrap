<p align="center">
  <a href="#">
    <img src="/ASSETS/logo.svg" alt="Kotlin-Bootstrap logo" width="200" height="165">
  </a>
</p>

<h3 align="center">Kotlin Bootstrap</h3>
<p>
  ⚡Highly experimental library built on top of the <a href="https://github.com/varabyte/kobweb" target="_blank" rel="noopener noreferrer">Kobweb</a> (Compose HTML framework). It allows you to use the official <a href="https://getbootstrap.com/" target="_blank" rel="noopener noreferrer">Bootstrap</a> UI components with Kotlin and Jetpack Compose, to build a frontend on the web. You are required to use the kobweb framework, otherwise it won't work. At the moment, components are not yet fully customizable, but I'll work on it. ⚽ The goal is to release all bootstrap components, and only then work on it's customization furthermore. Silk UI layer which is included with Kobweb is not required for this library to work.
</p>

## Available Components
- [Button](#button)
- [IconButton](#iconbutton)
- [Input](#input)
- [Dropdown](#dropdown)
- [TextArea](#textarea)
- [Checkbox](#checkbox)
- [RadioButton](#radiobutton)
- [Switch](#switch)
- [Alert](#alert)
- [Toast](#toast)
- [Modal](#modal)
- [Select](#select)
- [Range](#range)
- [Progress](#progress)
- [Spinner](#spinner)
- [Tooltip](#tooltip)
- [Collapse](#collapse)
- [Carousel](#carousel)
- [Breadcrumb](#breadcrumb)
- [Accordion](#accordion)
- [NavBar](#navbar)
- [Offcanvas](#offcanvas)
- [Badge](#badge)
- [CloseButton](#closebutton)
- [ColorPicker](#colorpicker)
- [FilePicker](#filepicker)
- [Pagination](#pagination)

## Bootstrap Icons usage
- [Icons](#icons)

## Install
Update a Project level `build.gradle.kts` file:

```gradle
repositories {
    ..
    maven(url = "https://jitpack.io")
}
```

Update a `site` module `build.gradle.kts` file:

```gradle
kobweb {
    app {
        index {
            head.add {
                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
                }
                // Optional, if you want to use Bootstrap Icons [BSIcons].
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css"
                }
            }
        }
    }
}

kotlin {
    @Suppress("UNUSED_VARIABLE") 
    sourceSets {
        ..
        val jsMain by getting {
            dependencies {
                ..
                implementation("com.github.stevdza-san:KotlinBootstrap:0.0.8")
            }
        }
    }
}
```

## Button
<p>
  <img src="/ASSETS/buttons.png" alt="Buttons Preview" width="812">
</p> 

<p>
  <img src="/ASSETS/loadingButton.gif?raw=true" width="268"/>
  <img src="/ASSETS/loadingButtonText.gif?raw=true" width="268"/>
    <img src="/ASSETS/badgeButton.gif?raw=true" width="268"/>
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

<p>Buttons with custom properties.</p>

<p>
  <img src="/ASSETS/custombuttons.gif?raw=true" alt="CustomButtons Preview" width="812">
</p> 

```kotlin
Column(modifier = Modifier.gap(20.px).fillMaxSize()) {
    Row(modifier = Modifier.gap(12.px)) {
        BSButton(
            text = "Apply Now",
            customization = ButtonCustomization(
                color = Colors.White,
                hoverColor = Colors.White,
                backgroundColor = Colors.Black,
                hoverBackgroundColor = rgba(0, 0, 0, 0.8),
                fontFamily = "Space Grotesk"
            ),
            onClick = {}
        )
        BSButton(
            text = "Get Started",
            customization = ButtonCustomization(
                color = Colors.White,
                hoverColor = Colors.White,
                activeColor = Colors.WhiteSmoke,
                borderColor = Colors.White,
                hoverBorderColor = Colors.White,
                activeBorderColor = rgb(168, 192, 255),
                gradient = linearGradient(
                    from = rgb(168, 192, 255),
                    to = rgb(63, 43, 150),
                    dir = LinearGradient.Direction.ToTopRight
                ),
                borderRadius = BSBorderRadius(all = 50.px),
                horizontalPadding = 1.25.cssRem
            ),
            onClick = {}
        )
    }
    Row(modifier = Modifier.gap(12.px)) {
        BSButton(
            text = "Submit",
            customization = ButtonCustomization(
                color = Colors.White,
                hoverColor = Colors.Wheat,
                activeColor = Colors.White,
                borderColor = Colors.White,
                hoverBorderColor = Colors.Wheat,
                activeBorderColor = Colors.White,
                gradient = linearGradient(
                    from = rgb(188, 78, 156),
                    to = rgb(248, 7, 89),
                    dir = LinearGradient.Direction.ToTopRight
                ),
                borderRadius = BSBorderRadius(topLeft = 20.px, bottomRight = 20.px),
                fontFamily = "Rubik"
            ),
            onClick = {}
        )
    }
}
```

## IconButton
<p>
  <img src="/ASSETS/iconbutton.gif?raw=true" alt="IconButtons Preview">
</p> 

`BSIconButton` is a component used to display a Bootstrap Icon (`BSIcons`) inside a button. You can customize similar properties like with a regular `BSButton` as well.
A basic usage:

```kotlin
Column(modifier = Modifier.gap(20.px).fillMaxSize()) {
    Row(modifier = Modifier.gap(12.px)) {
        BSIconButton(
            icon = BSIcons.UPLOAD,
            onClick = {}
        )
        BSIconButton(
            icon = BSIcons.UPLOAD,
            variant = ButtonVariant.PrimaryOutline,
            onClick = {}
        )
    }
    Row(modifier = Modifier.gap(12.px)) {
        BSIconButton(
            icon = BSIcons.ANDROID,
            variant = ButtonVariant.Success,
            onClick = {}
        )
        BSIconButton(
            icon = BSIcons.ANDROID,
            variant = ButtonVariant.SuccessOutline,
            onClick = {}
        )
    }
}
```

## Input
<p>
  <img src="/ASSETS/inputs.gif?raw=true" alt="Inputs Preview" width="360">
</p> 

<p>A simple usage with a placeholder:</p>

```kotlin
var inputValue by remember { mutableStateOf("") }
BSInput(
    value = inputValue,
    placeholder = "Type here",
    onValueChange = {
        inputValue = it
    }
)
```

<p>Floating style input field, where a label is animated:</p>

```kotlin
BSInput(
    value = inputValue,
    label = "Email Address",
    floating = true,
    onValueChange = {}
)
```

<p>Positive validation style input field:</p>

```kotlin
BSInput(
    value = inputValue,
    label = "Email Address",
    placeholder = "Type here",
    validation = InputValidation(
      isValid = true
    ),
    onValueChange = {}
)
```

<p>Negative validation style input field:</p>

```kotlin
BSInput(
    value = inputValue,
    label = "Email Address",
    placeholder = "Type here",
    validation = InputValidation(
      isInvalid = true
    ),
    onValueChange = {}
)
```

<p>Disabled input field:</p>

```kotlin
BSInput(
    value = inputValue,
    label = "Email Address",
    placeholder = "Type here",
    disabled = true,
    onValueChange = {}
)
```

<p>Plain text input field:</p>

```kotlin
BSInput(
    value = inputValue,
    label = "Email Address",
    placeholder = "Type here",
    plainText = true,
    onValueChange = {}
)
```

## Dropdown
<p>
  <img src="/ASSETS/dropdowns.png" alt="Dropdown Preview" width="812">
</p> 

<p>
  <img src="/ASSETS/placeholderDropdown.gif?raw=true" width="268"/>
  <img src="/ASSETS/darkBackgroundDropdown.gif?raw=true" width="268"/>
    <img src="/ASSETS/disabledDropdown.gif?raw=true" width="268"/>
</p>

<p>Dropdown with a placeholder:</p>

```kotlin
BSDropdown(
    placeholder = "Select a Platform",
    items = listOf("Android", "iOS", "Web"),
    onItemSelect = { index, value -> }
)
```

<p>Dropdown with a dark background:</p>

```kotlin
BSDropdown(
    items = listOf("Android", "iOS", "Web"),
    darkBackground = true,
    onItemSelect = { index, value -> }
)
```

<p>Disabled Dropdown item:</p>

```kotlin
BSDropdown(
    items = listOf("Android", "iOS", "Web"),
    disabledItems = listOf("iOS"),
    onItemSelect = { index, value -> }
)
```

## TextArea
<p>
  <img src="/ASSETS/textarea.gif?raw=true" alt="TextArea Preview" width="460">
</p> 


<p>Basic TextArea example with a label:</p>

```kotlin
var value by remember { mutableStateOf("") }
BSTextArea(
    value = value,
    label = "Email Address",
    placeholder = "Type here...",
    onValueChange = { value = it }
)
```

<p>Floating TextArea:</p>

```kotlin
var value by remember { mutableStateOf("") }
BSTextArea(
    value = value,
    label = "Email Address",
    floating = true,
    onValueChange = { value = it }
)
```

## Checkbox
<p>
  <img src="/ASSETS/checkboxes.gif?raw=true" alt="Checkboxes Preview" width="280">
</p> 

<p>Basic Checkbox usage:</p>

```kotlin
BSCheckbox(
    label = "Kotlin",
    onClick = {}
)
```

<p>Reversed order checkbox:</p>

```kotlin
BSCheckbox(
    label = "C++",
    reverse = true,
    onClick = {}
)
```

<p>Toggle button style checkbox:</p>

```kotlin
BSCheckbox(
    label = "Python",
    toggleButton = true,
    onClick = {}
)
```

## RadioButton
<p>
  <img src="/ASSETS/radiobuttons.gif?raw=true" alt="RadioButtons Preview">
</p> 

<p>Basic RadioButtonGroup usage:</p>

```kotlin
BSRadioButtonGroup {
    BSRadioButton(label = "Android", onClick = {})
    BSRadioButton(label = "iOS", onClick = {})
    BSRadioButton(label = "Web", onClick = {})
}
```

<p>RadioButtonGroup in a horizontal orientation:</p>

```kotlin
BSRadioButtonGroup(inline = true) {
    BSRadioButton(label = "Android", onClick = {})
    BSRadioButton(label = "iOS", onClick = {})
    BSRadioButton(label = "Web", onClick = {})
}
```

<p>ToggleButton style of a RadioButtonGroup:</p>

```kotlin
BSRadioButtonGroup(toggleButton = true) {
    BSRadioButton(label = "Android", onClick = {})
    BSRadioButton(label = "iOS", onClick = {})
    BSRadioButton(label = "Web", onClick = {})
}
```

## Switch
<p>
  <img src="/ASSETS/switches.gif?raw=true" alt="Switches Preview" width="700">
</p> 

<p>Switch with a default checked state:</p>

```kotlin
BSSwitch(
    label = "Android",
    defaultChecked = true,
    onClick = {}
)
```

<p>Disabled Switch with a default unchecked state:</p>

```kotlin
BSSwitch(
    label = "Android",
    disabled = true,
    onClick = {}
)
```

## Alert
<p>
  <img src="/ASSETS/alerts.gif?raw=true" alt="Alerts Preview" width="420">
</p> 

<p>Primary Style Alert with an Info icon and a bold text:</p>

```kotlin
BSAlert(
    message = "Visit my YouTube Channel: Stevdza-San",
    icon = AlertIcon.Info,
    bold = "Stevdza-San"
)
```

<p>Success Style Alert with a Checkmark icon and a link text:</p>

```kotlin
BSAlert(
    message = "You have successfully purchased a book!",
    alertLink = Pair("book", "https://google.com"),
    icon = AlertIcon.Checkmark,
    style = AlertStyle.Success
)
```

<p>Dismissable Alert:</p>

```kotlin
BSAlert(
    message = "Dismissable Alert.",
    dismissible = true,
    style = AlertStyle.Dark
)
```

## Toast
<p>
  <img src="/ASSETS/toast.gif?raw=true" alt="Taosts Preview">
</p> 

Even though a Toast component is not yet fully customizable, from this preview above you can see that there are different variations and styles that you can apply to it. For triggering a Toast component, you do need to call a special function `showToast(toastId)` and pass your toast id, in order to properly display it on the screen. Every Toast components needs to be wrapped inside the `BSToastGroup` composable. Also there's a `ToastPlacement` parameter available on `BSToastGroup` that you can use to modify a toast placement.

`BSToast` gets visible once you trigger a `showToast()` function:

```kotlin
BSToastGroup {
    BSToast(
        id = "toast",
        title = "Welcome",
        body = "Browse our website for more interesting products!",
        onCloseClick = {}
    )
}

BSButton(
    text = "Show Toast",
    onClick = {
        showToast("toast")
    }
)
```

`BSToastBasic` which is not automatically dismissable, because it has `autoHide` parameter equal to false:

```kotlin
BSToastGroup {
    BSToastBasic(
        id = "toastBasic",
        text = "Thank you for your feedback!",
        style = ToastStyle.Dark,
        autoHide = false,
        closeButtonDark = false,
        onCloseClick = {}
    )
}
```

`BSToastAction` which contains additional positive/negative buttons:

```kotlin
BSToastGroup {
    BSToastAction(
        id = "toastAction2",
        text = "Are you sure you want to delete 24 items?",
        positiveButtonText = "Yes",
        positiveButtonVariant = ButtonVariant.Primary,
        negativeButtonVariant = ButtonVariant.Danger,
        negativeButtonText = "Cancel",
        style = ToastStyle.Dark,
        onPositiveButtonClick = {},
        onNegativeButtonClick = {}
    )
}
```

## Modal
<p>
  <img src="/ASSETS/modal.gif?raw=true" alt="Modal Preview" width="560">
</p> 

`BSModal` component is not visible by default. If you want to show it on your page, then you need to call a modifier `showModalOnClick()` on a `BSButton` or any other clickable composable, and pass the ID of the modal itself. After you do that, just click the component that has that modifier, and your `BSModal` will appear.

<p>A basic Modal usage:</p>

```kotlin
BSModal(
    id = "contactModal",
    title = "Contact us",
    body = {
        Column {
            BSInput(
                modifier = Modifier
                  .fillMaxWidth()
                  .margin(bottom = 14.px),
                value = "",
                label = "Email Address",
                placeholder = "Type here...",
                onValueChange = {}
            )
            BSTextArea(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Message",
                placeholder = "Type here...",
                onValueChange = {}
            )
        }
    },
    positiveButtonText = "Send Message",
    negativeButtonText = "Close",
    onPositiveButtonClick = {},
    onNegativeButtonClick = {}
)

BSButton(
    modifier = Modifier.showModalOnClick(id = "contactModal"),
    text = "Trigger",
    onClick = {}
)
```

## Select
<p>
  <img src="/ASSETS/select.gif?raw=true" alt="Select Preview" width="360">
</p> 

<p>Select component's basic usage:</p>

```kotlin
BSSelect(
    items = listOf("Android", "iOS", "Web", "Desktop"),
    placeholder = "Choose a Platform",
    onItemSelected = { index, value -> }
)
```

<p>Floating style of a Select component:</p>

```kotlin
BSSelect(
    items = listOf("Android", "iOS", "Web", "Desktop"),
    placeholder = "Choose a Platform",
    floating = true,
    onItemSelected = { index, value -> }
)
```

## Range
<p>
  <img src="/ASSETS/range.gif?raw=true" alt="Range Preview" width="450">
</p> 

<p>Range's basic usage:</p>

```kotlin
BSRange(
    modifier = Modifier.width(300.px),
    label = "Range (0-10)",
    min = 0,
    max = 10,
    onSelect = {}
)
```

## Progress
<p>
  <img src="/ASSETS/progress.gif?raw=true" alt="Progress Preview" width="360">
</p> 

<p>Basic Progress component usage:</p>

```kotlin
BSProgress(percentage = 85.percent)
```

<p>Stripped style:</p>

```kotlin
BSProgress(
  percentage = 85.percent,
  striped = true
)
```

<p>Animated Stripped style:</p>

```kotlin
BSProgress(
  percentage = 85.percent,
  stripedAnimated = true
)
```


## Spinner
<p>
  <img src="/ASSETS/spinner.gif?raw=true" alt="Spinner Preview" width="600">
</p> 

<p>Default Spinner style:</p>

```kotlin
BSSpinner(variant = SpinnerVariant.Default)
```

<p>Grow Spinner style:</p>

```kotlin
BSSpinner(variant = SpinnerVariant.DefaultGrow)
```

## Tooltip
<p>
  <img src="/ASSETS/tooltip.gif?raw=true" alt="Tooltip Preview">
</p> 

Before you can use and display a Tooltip, you need to initialize them by calling `initializeTooltips()` function:

```kotlin
LaunchedEffect(Unit) {
    initializeTooltips()
}
```

Usually, the content on top of which you want to add a tooltip, is specified as a content lambda of the `BSTooltip` composable:

```kotlin
BSTooltip(
    text = "https://stevdza-san.com",
    content = {
        A(href = "https://stevdza-san.com") {
            SpanText(text = "Online Courses")
        }
    }
)
```

You can also change a direction of the tooltip, by using `TooltipDirection` parameter:

```kotlin
BSTooltip(
    text = "https://stevdza-san.com",
    direction = TooltipDirection.Right,
    content = {
        A(href = "https://stevdza-san.com") {
            SpanText(text = "Online Courses")
        }
    }
)
```

## Collapse
<p>
  <img src="/ASSETS/collapse.gif?raw=true" alt="Collapse Preview" width="500">
</p> 

To make your button or any other clickable component as the one that triggers the `BSCollapse`, you need to add a `.showCollapse(id)` modifier and pass the `BSCollapse` id.

```kotlin
Column(
    modifier = Modifier.width(400.px),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    BSButton(
        modifier = Modifier
            .alignContent(AlignContent.Center)
            .showCollapse(id = "collapse1"),
        text = "FAQ",
        onClick = {}
    )
    BSCollapse(id = "collapse1") {
        Column(modifier = Modifier.margin(top = 14.px)) {
            SpanText(
                modifier = Modifier
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold),
                text = "1. How long does the course take to complete?"
            )
            SpanText(
                text = """
                      The course is self-paced, so you can complete it at your own speed.
                      On average, most students finish the course in about 3-6 weeks, 
                      depending on the time they can dedicate to learning.
                """.trimIndent()
            )
        }
    }
}
```

## Carousel
<p>
  <img src="/ASSETS/carousel.gif?raw=true" alt="Carousel Preview" width="700">
</p> 

A basic usage of Carousel component:

```kotlin
BSCarousel(
    items = listOf(
        CarouselItem(
            image = "https://images.pexels.com/photos/2662116/pexels-photo-2662116.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            title = "Moraine Lake"
        ),
        CarouselItem(
            image = "https://images.pexels.com/photos/147411/italy-mountains-dawn-daybreak-147411.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            title = "Italy"
        ),
        CarouselItem(
            image = "https://images.pexels.com/photos/1166209/pexels-photo-1166209.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
            title = "Lavender"
        ),
    ),
    width = 900.px,
    height = 500.px
)
```

## Breadcrumb
<p>
  <img src="/ASSETS/breadcrumb.gif?raw=true" alt="Breadcrumb Preview">
</p> 

You can specify and replace a default `divider` parameter to change a separator string, and also you can set a currently selected `BreadcrumbItem` as well.

```kotlin
BSBreadcrumb(
    items = listOf(
        BreadcrumbItem(
            text = "Home",
            href = "#"
        ),
        BreadcrumbItem(
            text = "Pricing",
            href = "#"
        ),
        BreadcrumbItem(
            text = "Services",
            href = "#"
        ),
        BreadcrumbItem(
            text = "About",
            href = "#"
        ),
        BreadcrumbItem(
            text = "Contact us",
            href = "#"
        )
    ),
    divider = ">",
    currentItem = "About"
)
```

## Accordion
<p>
  <img src="/ASSETS/accordion.gif?raw=true" alt="Accordion Preview" width="500">
</p> 

You can customize it's `flush` parameter which will remove some borders and rounded corners to render accordions edge-to-edge with their parent container. `alwaysOpen` parameter will make accordion items stay open when another item is opened.

<p>Basic Accordion example:</p>

```kotlin
BSAccordion(
    modifier = Modifier.width(300.px),
    items = listOf(
        AccordionItem(
            title = "Step 01: Identify your goals",
            content = { SpanText(text = "Body text here...") },
            defaultOpened = true
        ),
        AccordionItem(
            title = "Step 02: Write your goals",
            content = {  SpanText(text = "Body text here...")}
        ),
        AccordionItem(
            title = "Step 03: Analysis",
            content = {  SpanText(text = "Body text here...")}
        ),
        AccordionItem(
            title = "Step 04: Objectives",
            content = { SpanText(text = "Body text here...")}
        )
    )
)
```

## NavBar
<p>
  <img src="/ASSETS/navbar.gif?raw=true" alt="NavBar Preview">
</p> 

The NavBar typically appears at the top of the web page and contains various navigation elements such as links, buttons, dropdown menus, and branding elements like logos or site names. It adapts to different screen sizes and devices, making it ideal for responsive web design.

```kotlin
BSNavBar(
    modifier = Modifier.fillMaxWidth(),
    stickyTop = true,
    itemsAlignment = Alignment.CenterHorizontally,
    brand = NavBarBrand(
        title = "KotlinBootstrap",
        image = "https://getbootstrap.com/docs/5.3/assets/brand/bootstrap-logo.svg",
        href = "#"
    ),
    expand = NavBarExpand.LG,
    backgroundStyle = BackgroundStyle.Dark,
    items = listOf(
        NavLink(
            id = "homeLink",
            title = "Home",
            onClick = {
                println("Index: $it Title: Home")
            }   
        ),
        NavLink(
            id = "servicesLink",
            title = "Services",
            onClick = {}
        ),
        NavLink(
            id = "pricingLink",
            title = "Pricing",
            onClick = {}
        ),
        NavLink(
            id = "aboutLink",
            title = "About us",
            onClick = {}
        ),
        NavDropdown(
            placeholder = "Language",
            items = listOf(
                NavDropdownItem(
                    id = "kotlinLanguage",
                    title = "Kotlin",
                    onClick = {
                        println("Index: $it Title: Kotlin")
                    }
                ),
                NavDropdownItem(
                    id = "javaLanguage",
                    title = "Java",
                    onClick = {}
                )
            )
        )
    ),
    inputField = NavBarInputField(
        placeholder = "Search",
        value = "",
        onValueChange = {}
    ),
    button = NavBarButton(
        text = "Search",
        onClick = {}
    )
)
```

<p>
  <img src="/ASSETS/navbar2.gif?raw=true" alt="NavBar Preview">
</p> 

You can add an extra parameter, to replace a default expandable menu with an `Offcanvas` side bar:
```kotlin
BSNavBar(
    ..
    offcanvas = NavBarOffcanvas(
        id = "myOffcanvas",
        title = "KotlinBootstrap",
        dark = true
    )
    ..
)
```

## Offcanvas
<p>
  <img src="/ASSETS/offcanvas.gif?raw=true" alt="Offcanvas Preview">
</p> 

Offcanvas is used to create sidebar or panel that can slide in and out of the viewport. This component is often used to display additional content, navigation menus, or options without taking up the entire screen space.

```kotlin
val links = listOf("Home", "Pricing", "Services", "Contact us")
BSOffcanvas(
    id = "myOffCanvas",
    title = "Welcome!",
    body = {
        Column {
            links.forEach { name ->
                A(
                    attrs = Modifier
                        .margin(bottom = 16.px)
                        .textDecorationLine(TextDecorationLine.None)
                        .cursor(Cursor.Pointer)
                        .toAttrs()
                ) {
                    SpanText(name)
                }
            }
            BSButton(
            text = "Sign in",
            onClick = {}
            )
        }
    },
    placement = OffcanvasPlacement.END
)

Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    BSButton(
        modifier = Modifier.showOffcanvasOnClick(id = "myOffCanvas"),
        text = "Show",
        onClick = {}
    )
}
```

## Badge
<p>
  <img src="/ASSETS/badge.png" alt="Badge Preview">
</p> 

There are four different `BadgeVariant`'s: Straight, Regular, Rounded, Empty. You can customize the `BackgroundStyle` of the badge, a `fontFamily`, `fontSize`, and `fontWeight` as well.

```kotlin
Row(verticalAlignment = Alignment.CenterVertically) {
    SpanText(
        modifier = Modifier.margin(right = 8.px),
        text = "Fitness Tracker"
    )
    BSBadge(
        modifier = Modifier.margin(bottom = 8.px),
        text = "New",
        variant = BadgeVariant.Straight
    )
}
```

## CloseButton
<p>
  <img src="/ASSETS/closebutton.gif?raw=true" alt="CloseButton Preview">
</p> 

A basic usage:

```kotlin
BSCloseButton()
```

## ColorPicker
<p>
  <img src="/ASSETS/colorpicker.gif?raw=true" alt="ColorPicker Preview">
</p> 

A basic usage:

```kotlin
BSColorPicker(onColorSelected = {})
```

## FilePicker
<p>
  <img src="/ASSETS/filepicker.gif?raw=true" alt="FilePicker Preview">
</p> 

FilePicker component provides a required lambda `onFileSelected`, that returns two strings. The first one represents a fileName, while the second one the actual file encoded in BASE_64 string.

A basic usage:

```kotlin
BSFileInput(
    label = "Choose a file",
    onFileSelected = { fileName, file -> }
)
```

## Pagination
<p>
  <img src="/ASSETS/pagination.gif?raw=true" alt="Pagination Preview">
</p> 

`BSPagination` component is used to divide long lists or tables into multiple pages, making it easier for users to navigate through the content.

A basic usage:

```kotlin
var currentPage by remember { mutableStateOf(1) }

BSPagination(
    pages = 15,
    maxVisiblePages = 3,
    currentPage = currentPage,
    previousButton = PreviousButton(
        onClick = { currentPage = it }
    ),
    nextButton = NextButton(
        onClick = { currentPage = it }
    ),
    onPageClick = { currentPage = it }
)
```

## Icons
There are over 2.000 icons available in a Bootstrap library. You can use a `BSIcons` object to access all icons. There's a `BSIcon` composable function that allows you to display those same icons as well. There's also a `BSIconButton` composable that displays an icon inside the button.

Example *(Zoomed in)* icon, that represents one of the many vector icons in the library:

```kotlin
BSIcon(
  icon = BSIcons.ANDROID,
  size = 1.cssRem,
  color = Colors.LightGreen
)
```

<p>
  <img src="/ASSETS/androidIcon.png" alt="Android Icon Preview">
</p> 
