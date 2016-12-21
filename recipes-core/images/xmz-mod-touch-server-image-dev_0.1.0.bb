include xmz-mod-touch-server-image_0.1.0.bb

IMAGE_INSTALL += " \
  wireless-tools \
  wpa-supplicant \
  ethtool \
  linux-firmware \
  broadcom-firmware \
"

IMAGE_INSTALL += " \
  pkgmgr \
"

IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURES += "package-management"
# CORE_IMAGE_EXTRA_INSTALL += "apt"
