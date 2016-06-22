# Google Static Map Url Builder
Utility for creating Google static maps url with a few simple options.

##Synopsis
Sometimes, we need to present a grid screen with some google maps as thumbnails, but, for android apps, you need to include google play services, and use google maps api for loading `MapFragment` instances, specifically using _lite mode_.

For a simpler approach, you can use the [Google Static Maps API](https://goo.gl/0hG1pu) for construct such image map urls using some parameters.

With this library, you can apply for the second note, yeah, you can build static maps image urls, using options like latitude, longitude, zoom, image width and height, and adding markers to the map.

It uses the _Fluent Builder pattern_, making this process as simple as possible.

##Usage
Add dependency.

```
(Gradle)
dependencies {
  compile 'com.github.marlonlom:staticmaps-builder:1.0.0'
}

(Maven)
<dependency>
    <groupId>com.github.marlonlom</groupId>
    <artifactId>staticmaps-builder</artifactId>
    <version>1.0.0</version>
</dependency>
```

This repository contains the sample module, you can check it out.

For creating static maps, use the `StaticMapUrl` class

```java
StaticMapUrl.create()
  .centered(_latitude_, _longitude_)
  .size(_imageWidth_, _imageHeight_)
  .zoom(_zoom_)
  .mark(_marker_)
  .build();
```

The result is a string containing the url:

[Sample generated static map](http://maps.googleapis.com/maps/api/staticmap?&center=-34.615803,-58.50336&size=320x320&zoom=8&markers=color:blue|size:mid|-34.615803,-58.50336)

For creating markers and add it to the static maps, use the `StaticMapMarker` class

```java
StaticMapMarker.create(_color_, _latitude_, _longitude_).medium())
```

The color for the marker can be set as a 24-bit color (example: color=0xFFFFCC) or a predefined color using the folowwing set (black, brown, green, purple, yellow, blue, gray, orange, red, white).

The size of the marker is important, there are three methods, that must be used after _`create()`_ method: _`small()`, `medium()`, `tiny()`_

###Demo

Check the [Demo](https://goo.gl/hI8T6S) here.

##Spread the word

If you like this library, please tell others about it :thumbsup::thumbsup:

<a href="https://twitter.com/intent/tweet?text=Showing%20many%20maps%20in%20a%20grid%3F%20Check%20out%20this%20awesome%20library%20on%20Github%3A%20https://github.com/marlonlom/staticmaps_builder" target="_blank" title="share to twitter" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/twitter_icon.png" title="Share on Twitter" width="35" height=35 />
<a href="https://plus.google.com/share?url=https://github.com/marlonlom/staticmaps_builder" target="_blank" title="share to G+" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/googleplus_icon.png" target="_blank"  title="Share on Google+" width="35" height=35 />
<a href="https://www.facebook.com/sharer/sharer.php?u=https://github.com/marlonlom/staticmaps_builder" target="_blank" title="share to facebook" style="width:100%"><img src="https://github.com/marlonlom/staticmaps_builder/blob/master/design/facebook_icon.png" title="Share on Facebook" width="35" height=35 />

 - []()Follow me on **Twitter**: [**@Marlonlom**](https://twitter.com/marlonlom)
 - Contact me on **LinkedIn**: [**Marlonlom**](https://co.linkedin.com/in/marlonlom)


###License

```
Copyright 2016 marlonlom

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
