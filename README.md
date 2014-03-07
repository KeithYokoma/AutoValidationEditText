# AutoValidationEditText

Simple implementation for alert validation result with EditText appearance.

## Usage

Just put the customized EditText with some attributes we need.

```xml
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:sample="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <jp.yokomark.widget.edittext.validation.AutoValidationEditText
        android:text="@string/hello_world"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        sample:minLengthThreshold="5"
        sample:maxLengthThreshold="10"
        sample:alertType="textColor"
        sample:alertColor="#EDA098"
        sample:normalColor="#000000"/>
</RelativeLayout>
```

| Attribute | Possible value | Description |
|----|----|----|
| `minLengthThreshold` | `integer` | Required minimum length of the input |
| `maxLengthThreshold` | `integer` | Required maximum length of the input |
| `alertType` | any of `textColor`, `backgroundColor`, `errorTip` | Appearance type for the alert view |
| `alertColor` | `color` | Appearance value for use with `textColor` and/or `backgroundColor`, especially alerting color |
| `alertMessage` | `string` | Appearance value for use with `errorTip` |
| `normalColor` | `color` | Appearance value for use with `textColor` and/or `backgroundColor`, especially indicating valid color |

## TODO

- Pattern matching validation

## Download

Via gradle

```
repositories {
    mavenCentral()
    maven { url 'https://raw.github.com/KeithYokoma/AutoValidationEditText/master/repository/' }
}
android {
    dependencies {
        compile 'jp.yokomark.widget:AutoValidationEditText:1.0.0'
    }
}
```

## License

```
Copyright (C) 2014 KeithYokoma. All rights reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
