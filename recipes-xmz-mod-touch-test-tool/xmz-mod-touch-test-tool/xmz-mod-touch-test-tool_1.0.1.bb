inherit cargo

SUMMARY = "Test Tool für die 'xMZ-Mod-Touch' Hardware"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-TestTool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-TestTool.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PR = "r0"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"

RDEPENDS_${PN} += "xmz-mod-touch-test-tool-init"
RDEPENDS_${PN} += "gtk+3 libmodbus"
