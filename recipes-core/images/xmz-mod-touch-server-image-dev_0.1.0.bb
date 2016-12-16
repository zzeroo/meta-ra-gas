include xmz-mod-touch-server-image_0.1.0.bb

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


RDEPENDS_${PN}-dev += " \
  rust-bin \
  cargo-bin \
"
