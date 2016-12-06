inherit cargo

SUMMARY = "Gtk+3 Hello World in Rust"
HOMEPAGE = "https://github.com/zzeroo/hello-world-rs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "git://git@github.com/zzeroo/hello-world-rs.git;protocol=ssh;branch=gtk3"

SRCREV = "f49feab62d345776c491e89bcd8fcd0428fda848"
PR = "r1"
PV = "1.0+git${SRCPV}"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"
