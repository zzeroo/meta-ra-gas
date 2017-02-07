SUMMARY = "opkg package manager"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  file://base-feeds.conf \
  "
S = "${WORKDIR}"

PR = "r1"

do_install() {
	install -Dm0644 ${WORKDIR}/base-feeds.conf ${D}${sysconfdir}/opkg/base-feeds.conf
}
