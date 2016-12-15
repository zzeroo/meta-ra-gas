# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

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
	packagegroup-fonts-truetype \
	adwaita-icon-theme \
"
