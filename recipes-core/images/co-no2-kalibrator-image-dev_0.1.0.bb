include co-no2-kalibrator-image_0.1.0.bb

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
