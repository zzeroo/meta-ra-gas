OpenEmbedded/ Yocto Layer mit den Programmen der RA-GAS GmbH sowie deren Abhängigkeiten


# Abhängikeiten

Folgende Abhängigkeiten müssen erfüllt sein.

```
URI: git://git.yoctoproject.org/poky
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

## Git Repositories

```
git clone  git://git.yoctoproject.org/poky
cd poky

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
