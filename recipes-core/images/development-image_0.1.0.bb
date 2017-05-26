include basic-image.bb

PR = "r4"

# Auto resize root filesystem on first boot
IMAGE_INSTALL += "resize-rootfs"

#Rust support (indirect, you have to call `rustup-init --default-toolchain nightly -y` on the target)
IMAGE_INSTAL += "rustup-init"

# WLAN Tools and firmware
IMAGE_INSTALL += " \
  wireless-tools \
  wpa-supplicant \
  wlan-config \
  ethtool \
  linux-firmware \
  broadcom-firmware \
"
# Packet managment
IMAGE_INSTALL += " \
  pkgmgr \
"
# Custom tools
# TODO: Packetgroup?
IMAGE_INSTALL += " \
  vim \
  git \
  tmux \
  zsh \
  curl \
"

IMAGE_INSTALL += " \
     e2fsprogs-resize2fs \
"

# SSH Server
IMAGE_FEATURES += "ssh-server-openssh"
# Packet managment
IMAGE_FEATURES += "package-management"

#IMAGE_FEATURES += "dbg-pkgs dev-pkgs ptest-pkgs tools-sdk tools-debug eclipse-debug tools-profile tools-testapps"
#IMAGE_FEATURES += "tools-sdk tools-debug tools-profile tools-testapps" # slang compelliert nicht auf arch linux 03.03.2017
IMAGE_FEATURES += "tools-debug"




#CORE_IMAGE_EXTRA_INSTALL += "apt"
CORE_IMAGE_EXTRA_INSTALL += "opkg"
