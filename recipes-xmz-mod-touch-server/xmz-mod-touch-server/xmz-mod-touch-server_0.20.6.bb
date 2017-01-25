inherit cargo

SUMMARY = "Serverteil der 'xMZ-Mod-Touch'-Platform"
HOMEPAGE = "https://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/Kliemann-Service-GmbH/xMZ-Mod-Touch-Server.git;branch=master;protocol=https \
  file://boot.mount \
"
SRCREV = "${AUTOREV}"
PV = "git-${SRCPV}"

S = "${WORKDIR}/git"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus xmz-mod-touch-server-image"
RDEPENDS_${PN} += "gtk+3 libmodbus vim git curl"
RDEPENDS_${PN} += "xmz-mod-touch-configuration"
RDEPENDS_${PN} += "xmz-mod-touch-server-init"

cargo_do_compile_append() {
  for f in ${S}/examples/*.rs; do
    cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
  done
}

# Kopiert die xMZ-Mod-Touch.json Konfigurationsdatei Vorlage nach /usr/share
do_install_append() {
  install -Dm0644 ${S}/share/xMZ-Mod-Touch.json.production ${D}/usr/share/xmz-mod-touch-server/xMZ-Mod-Touch.json.production
  # Install examples
  for f in ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/*; do
    if [ -f "$f" ] && [ -x "$f" ]; then
      install -m 0755 "$f" "${D}${bindir}"
      bbnote "file installed: $f"
    fi
  done

  # Systemd Unit file config checker
  install -Dm0644 ${WORKDIR}/boot.mount ${D}${systemd_system_unitdir}/boot.mount
}

FILES_${PN} += " \
  /usr/local/bin/ \
"
