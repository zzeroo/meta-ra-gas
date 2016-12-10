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

# Hello World example
IMAGE_INSTALL += " \
	gtk+3 \
	xorg-fonts-100dpi \
	adwaita-icon-theme \
"
