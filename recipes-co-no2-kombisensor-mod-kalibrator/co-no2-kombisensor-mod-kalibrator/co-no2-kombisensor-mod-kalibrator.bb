inherit cargo

SUMMARY = "CO-NO2-Kombisensor-Mod-Kalibrator"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator.git;protocol=https"

PV = "1.0+git${SRCPV}"
SRCREV = "b4f5b9959b624a6b84bd39d3181d541907b41e89"
PR = "r3"

S = "${WORKDIR}/git"

# # Fix: No GNU_HASH in the elf binary
# INSANE_SKIP_${PN} = "ldflags"
# INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus glibc"
RDEPENDS_${PN} += "gtk+3 libmodbus glibc"

INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"
