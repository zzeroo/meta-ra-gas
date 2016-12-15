inherit cargo

SUMMARY = "CO-NO2-Kombisensor-Mod-Kalibrator"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator.git;protocol=https"

SRCREV = "8f5ac398b3caa3fb40891d50e2d8d29188652d21"
PR = "r1"

S = "${WORKDIR}/git"

# # Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus glibc"
RDEPENDS_${PN} += "gtk+3 libmodbus glibc"
