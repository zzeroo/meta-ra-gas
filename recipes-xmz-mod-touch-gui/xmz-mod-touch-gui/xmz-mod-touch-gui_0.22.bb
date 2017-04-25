inherit cargo

SUMMARY = "Grafische Oberfläche der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/zzeroo/xMZ-Mod-Touch-GUI.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/zzeroo/xMZ-Mod-Touch-GUI.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

PR = "r5"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 xmz-mod-touch-server"
RDEPENDS_${PN} = "xmz-mod-touch-gui-init"
