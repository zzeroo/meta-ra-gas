SUMMARY = "xMZ-Mod-Touch-GUI systemd unit"
HOMEPAGE = "https://github.com/zzeroo/xMZ-Mod-Touch-GUI.git"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  file://gtk-betas.service \
"
PR = "r0"
S = "${WORKDIR}"

do_install() {
	install -Dm0644 ${WORKDIR}/gtk-betas.service ${D}${systemd_system_unitdir}/gtk-betas.service
}

inherit systemd

RDEPENDS_${PN} = "gtk-betas"

SYSTEMD_SERVICE_${PN} = "gtk-betas.service"
