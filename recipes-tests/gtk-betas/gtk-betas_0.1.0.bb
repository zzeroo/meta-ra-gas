inherit cargo

SUMMARY = "Beta window tests for gtk guis "
HOMEPAGE = "https://github.com/zzeroo/gtk-betas"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
  gitsm://github.com/zzeroo/gtk-betas.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

PR = "r19"

# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

DEPENDS = "gtk+3 libmodbus"


# # Include the examples into the image
# cargo_do_compile_append() {
#   for f in ${S}/examples/*.rs; do
#     cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
#   done
# }
#
# # Install examples
# do_install_append() {
#   for f in ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/*; do
#     if [ -f "$f" ] && [ -x "$f" ]; then
#       install -m 0755 "$f" "${D}${bindir}"
#       bbnote "file installed: $f"
#     fi
#   done
# }
