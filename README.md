RadioactiveWorld Bukkit Plugin
==============================

This is a Bukkit Plugin which I wrote years ago. Since it had a few downloads, I decided to release the code for others to have fun with it. 

Tested with CB 1.5.2-R0.1.

License: MIT.


Original BukkitDev description
==============================

A special map with highly increased difficulty!

Story
-----
The world is radioactive, only a few people were able to save themselves and escaped into a cave. They only had a few animals and basic things like wheat and water. Now, they have to survive, the overworld is contaminated forever. Only an expensive suit can protect from radiation; the radiation is less great at night.

This game is great for co-op & trading! It's more hard to get enough items to survive!

Features
--------
* players receive damage when the light level is higher than 15 (if they are in a water block: level 12)
* radiation suits (full (modified) diamond armor) prevents from beeing damaged by the sunlight
* multiworld support
* permission to bypass the damage (can be disabled)

Usage
-----
To craft a radiation suit, a diamond armor part with 8 (configurable) emeralds has to be put in the crafting field (it's a shapeless recipe): (see crafing.png in repository)

You need a Radiation Helmet, Radiation Chestplate, Radiation Leggings and Radiation Boots in order to be protected from radiation.

How to
------
- create a new map with big cave with animals, farms and whatever you like; don't forget to set the spawn point there
- set difficulty to normal; otherwise, it's boring
- install the plugin (instructions below)

Configuration
-------------
Just copy RadioactiveWorld.jar into your plugins-folder. Config files will be created on first run.

config.yml
----------
* `worlds`: list of worlds in which the plugin will be active
* `permission`: boolean; if set to false, the permissions will have no effect
* `armorcost`: integer; from 0 to 8: number of emeralds needed for crafting a part of a suit
* `playerdamage`: integer; player's damage per tick
* `armordamage`: float; damage of the radiation suit per tick

Permissions
-----------
* `RadioactiveWorld.bypass`: disables the plugin for the player
