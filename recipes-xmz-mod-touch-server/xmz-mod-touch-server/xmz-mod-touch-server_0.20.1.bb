inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=neustart;protocol=https"

SRCREV = "7f42c5dc93df5d53529ccea389a7ebe618b000ea"
PR = "r2"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"
RDEPENDS_${PN} += "gtk+3 libmodbus"
