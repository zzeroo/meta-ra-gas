include co-no2-kalibrator-image.bb

IMAGE_INSTALL += " \
  wireless-tools \
  wpa-supplicant \
  ethtool \
  linux-firmware \
  broadcom-firmware \
  network-configuration \
  dhcp-client \
"

IMAGE_FEATURES += "ssh-server-openssh"
