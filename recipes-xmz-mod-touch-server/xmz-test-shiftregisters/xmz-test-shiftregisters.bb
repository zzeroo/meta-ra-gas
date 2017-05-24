inherit cargo

SUMMARY = "Test der ShiftRegister"
HOMEPAGE = "https://github.com/zzeroo/xmz-test-shiftregisters"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = " \
  gitsm://github.com/zzeroo/xmz-test-shiftregisters.git;branch=master;protocol=https \
"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
PR = "r0"


# Fix: No GNU_HASH in the elf binary
INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"

# # Examples sollen auch alle mit in das Image eingebunden werden.
# cargo_do_compile_append() {
#   for f in ${S}/examples/*.rs; do
#     cargo build --example $(basename -s.rs $f) ${CARGO_BUILD_FLAGS}
#   done
# }
#
# # Install examples
# cargo_do_install_append() {
#   target/arm-unknown-linux-gnueabihf/release/examples/
#   for f in ${WORKDIR}/target/arm-unknown-linux-gnueabihf/release/examples/*; do
#     if [ -f "$f" ] && [ -x "$f" ]; then
#       install -Dm 0755 "$f" "${D}${bindir}"
#       FILES_${PN} += "${bindir}${f}"
#       bbnote "file installed: $f"
#     fi
#   done
# }
#
# # Leere `do_install()` Funktion, weil libmodbus-rs keine Programme buildet (keine main.rs hat)
# do_install() {
#   :
# }
