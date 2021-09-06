<template>
  <global-footer class="footer custom-render">
    <template v-slot:links>
      <a href="https://gitee" target="_blank">Gitee</a>
      <a href="https://github" target="_blank">Github</a>
    </template>
    <template v-slot:copyright>
      <a href="https://www.baidu.com" target="_blank">SDB-SCM</a>
    </template>
  </global-footer>
</template>

<script>
import { GlobalFooter } from '@/components/ProLayout'

export default {
  name: 'ProGlobalFooter',
  components: {
    GlobalFooter
  }
}
</script>
