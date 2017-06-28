inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

PR = "r6-2"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus xmz-mod-touch-server-image"
RDEPENDS_${PN} += "xmz-mod-touch-server-configuration"
RDEPENDS_${PN} += "xmz-mod-touch-server-init"


# Konfiguraton Managment
# Kopiert die xMZ-Mod-Touch.json Konfigurationsdatei Vorlage nach /usr/share
do_install_append() {
  install -Dm0644 ${S}/share/xMZ-Mod-Touch.json.development ${D}/usr/share/xmz-mod-touch-server/xMZ-Mod-Touch.json.development
  install -Dm0644 ${S}/share/xMZ-Mod-Touch.json.production ${D}/usr/share/xmz-mod-touch-server/xMZ-Mod-Touch.json.production
}

# # Examples sollen auch alle mit in das Image eingebunden werden.
# cargo_do_compile_append() {
#   for f in ${S}/examples/*.rs; do
#     cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
#   done
# }
#
# # Install examples
# cargo_do_install_append() {
#   for f in ${WORKDIR}/target/armv7-unknown-linux-gnueabihf/release/examples/*; do
#     if [ -f "$f" ] && [ -x "$f" ]; then
#       install -Dm 0755 "$f" "${D}${bindir}"
#       bbnote "file installed: $f"
#     fi
#   done
# }
