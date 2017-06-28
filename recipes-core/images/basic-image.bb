# Base this image on core-image-minimal
#include recipes-core/images/core-image-minimal.bb
include recipes-core/images/core-image-base.bb

PR = "r2"

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
  wayland \
	weston \
	weston-init \
	weston-disable-mousepointer \
"

IMAGE_INSTALL += " \
	gtk+3 \
	adwaita-icon-theme \
"

IMAGE_INSTALL += " \
	locale-base-de-de \
	coreutils-locale-de \
"
