inherit cargo

SUMMARY = "CO-NO2-Kombisensor-Mod-Kalibrator"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = " \
  gitsm://github.com/Kliemann-Service-GmbH/CO-NO2-Kombisensor-Mod-Kalibrator.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
# PV = "git-${SRCPV}"
S = "${WORKDIR}/git"

PR = "r1"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"
RDEPENDS_${PN} += "gtk+3 libmodbus"
