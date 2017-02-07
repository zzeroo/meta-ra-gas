include xmz-mod-touch-server-image_0.1.1.bb

PR = "r2"

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
CORE_IMAGE_EXTRA_INSTALL += "apt"
