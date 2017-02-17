include basic-image.bb

PR = "r1"

# WLAN Tools and firmware
IMAGE_INSTALL += " \
  wireless-tools \
  wpa-supplicant \
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
  zsh tmux \
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
IMAGE_FEATURES += "tools-debug tools-profile tools-testapps"




#CORE_IMAGE_EXTRA_INSTALL += "apt"
CORE_IMAGE_EXTRA_INSTALL += "opkg"
