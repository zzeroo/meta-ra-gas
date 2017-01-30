include xmz-mod-touch-server-image_0.1.1.bb

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
#
# IMAGE_INSTALL += " \
#      rustup-init \
# "

IMAGE_INSTALL += " \
     e2fsprogs-resize2fs \
"

# # development tools
# IMAGE_INSTALL += " \
#      packagegroup-core-buildessential \
#      packagegroup-core-tools-debug \
#      packagegroup-core-tools-profile \
#      kernel-modules \
#      ${CORE_IMAGE_EXTRA_INSTALL} \
#

# # development tools, too
# IMAGE_FEATURES += "dev-pkgs tools-sdk tools-debug tools-profile \
# debug-tweaks splash"

# # Rust geht nicht
# IMAGE_INSTALL += " \
#     rust-bin \
#     cargo-bin \
# "
# IMAGE_INSTALL += " \
#   rust-native \
#   cargo-native \
# "

# SSH Server
IMAGE_FEATURES += "ssh-server-openssh"
# Packet managment
IMAGE_FEATURES += "package-management"
CORE_IMAGE_EXTRA_INSTALL += "apt"
