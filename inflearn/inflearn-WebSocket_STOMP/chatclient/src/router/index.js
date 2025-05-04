import {createRouter, createWebHistory} from "vue-router";
import MemberCreate from '@/views/MemberCreate.vue'
import LoginPage from '@/views/LoginPage.vue'
import MemberList from '@/views/MemberList.vue'
import SimpleWebSocket from '@/views/SimpleWebSocket.vue'
import StompChatPage from '@/views/StompChatPage.vue'
import GroupChattingList from '@/views/GroupChattingList.vue'

const routes = [
    {
        path: '/member/create',
        name: 'MemberCreate',
        component: MemberCreate
    },
    {
        path: '/login',
        name: 'LoginPage',
        component: LoginPage
    },
    {
        path: '/member/list',
        name: 'MemberList',
        component: MemberList
    },
    {
        path: '/simple/chat',
        name: 'SimpleWebSocket',
        component: SimpleWebSocket
    },
    {
        path: '/chatPage/:roomId',
        name: 'StompChatPage',
        component: StompChatPage
    },
    {
        path: '/group-chatting/list',
        name: 'GroupChattingList',
        component: GroupChattingList
    }
]
const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router