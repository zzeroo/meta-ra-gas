SUMMARY = "Wlan Configuration via systemd unit files"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += " \
  file://resolv.conf \
"

PR = "r2"
S = "${WORKDIR}"

do_install_append() {
	install -Dm0644 ${WORKDIR}/resolv.conf ${D}${systemd_system_unitdir}/resolv.conf
}

FILES_${PN} = " \
  /lib/systemd/system/resolv.conf \
"
