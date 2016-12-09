# Base this image on core-image-minimal
include recipes-core/images/core-image-minimal.bb

# Base this image on core-image-minimal
# include recipes-core/images/core-image-weston.bb

# Include modules in rootfs
IMAGE_INSTALL += " \
	kernel-modules \
  wayland \
	weston \
	weston-init \
	"

# Hello World example
IMAGE_INSTALL += " \
	gtk+3 \
	hello-world-gtk3-rs \
	co-no2-kombisensor-mod-kalibrator \
	co-no2-kombisensor-mod-kalibrator-init \
"
