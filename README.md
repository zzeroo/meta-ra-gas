OpenEmbedded/ Yocto Layer mit den Programmen der RA-GAS GmbH sowie deren Abhängigkeiten


# Abhängikeiten

Folgende Abhängigkeiten müssen erfüllt sein.

/mnt/src/poky/meta \
/mnt/src/poky/meta-poky \
/mnt/src/poky/meta-openembedded/meta-oe \
/mnt/src/poky/meta-yocto-bsp \
/mnt/src/poky/meta-lemaker \
/mnt/src/poky/meta-ra-gas \
/mnt/src/poky/meta-rust-bin

```
URI: git://git.yoctoproject.org/poky
branch: master
revision: HEAD

URI: git://git.openembedded.org/meta-openembedded
sub folder: meta-oe
branch: master
revision: HEAD

URI: git://github.com/zzeroo/meta-lemaker
branch: master
revision: HEAD

URI: git://github.com/zzeroo/meta-ra-gas
branch: master
revision: HEAD

URI:git://github.com/rust-embedded/meta-rust-bin
branch: master
revision: HEAD
```

# Inhaltsverzeichnis

* [Git Repositories](#git-repositories)
* [Konfiguration Layer](#konfiguration-layer)]
* [Build Environment starten](#build-environment-starten)
* [Lokale Konfiguration](#lokale-konfiguration)

## Git Repositories

```
git clone  git://git.yoctoproject.org/poky
cd poky

git clone git://git.openembedded.org/meta-openembedded
git clone  git://github.com/zzeroo/meta-lemaker
git clone  git://github.com/zzeroo/meta-ra-gas
git clone git://github.com/rust-embedded/meta-rust-bin
```

## Build Environment starten

```
source ./oe-init-build-env
```

## Konfiguration Layer

```
vim conf/bblayers.conf
```

```
  BBLAYERS ?= " \
    /mnt/src/poky/meta \
    /mnt/src/poky/meta-poky \
    /mnt/src/poky/meta-yocto-bsp \
    /mnt/src/poky/meta-lemaker \
    /mnt/src/poky/meta-ra-gas \
    /mnt/src/poky/meta-rust-bin \
    "
```

## Lokale Konfiguration

Nun muss noch die lokale Konfiguration ergänzt werden.

```
vim conf/local.conf
```

Wichtig ist die Maschine zu setzen. Alle RA-GAS Produkte basieren auf dem
Lemaker Banana Pro Board.

```
MACHINE ??= "bananapro"
```

Die folgenden Enträge müssen ganz am Ende der Datei `conf/local.conf` eingetragen
werden. Diese Zeilen sorgen dafür dass systemd als init System verwendet wird.

```
# Systemd on and exclusive
DISTRO_FEATURES_append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_initscripts = ""

DISTRO_FEATURES_append = " wayland fbdev egl"
```
